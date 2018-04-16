package com.gtnexus.pmm.app.extract.gitmap;

import static com.gtnexus.pmm.app.AppXpressConstants.$;
import static com.gtnexus.pmm.app.AppXpressConstants.CUSTOM_OBJECT_MODULE;
import static com.gtnexus.pmm.app.AppXpressConstants.DESIGNS;
import static com.gtnexus.pmm.app.AppXpressConstants.JS_EXTENSION;
import static com.gtnexus.pmm.app.AppXpressConstants.SCRIPTS;
import static com.gtnexus.pmm.app.AppXpressConstants.SCRIPT_DESIGN;
import static com.gtnexus.pmm.app.AppXpressConstants.ZIP_EXTENSION;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gtnexus.pmm.api.v100.cli.option.CommandOption;
import com.gtnexus.pmm.api.v100.command.SubCommandException;
import com.gtnexus.pmm.api.v100.service.FileService;
import com.gtnexus.pmm.api.v100.service.PlatformModuleManagerServices;
import com.gtnexus.pmm.app.extract.cli.ExtractorOption;
import com.gtnexus.pmm.app.extract.exception.PMExtractorException;
import com.gtnexus.pmm.app.service.FileServiceImpl;

/**
 * Relies on Preparation, then takes extracted platform and maps it to the
 * existing Git directories.
 * 
 * @author Andrew Reynolds
 * @author Eric Hu
 * @author John Donovan
 * @version 1.0
 * @date 8-27-2014 GT Nexus
 */
public class GitMapper {

    private final GitMapVO vo;
    private List<Path> overwrittenScripts;
    private final GitMapPrep prep;
    private final FileService fs;

    public static GitMapper createMapper(PlatformModuleManagerServices services, Map<CommandOption, String> optionMap) {
	if (optionMap.containsKey(ExtractorOption.PLATFORM_ZIP)) {
	    String platformZip = optionMap.get(ExtractorOption.PLATFORM_ZIP);
	    if (!platformZip.endsWith(ZIP_EXTENSION)) {
		platformZip = platformZip + ZIP_EXTENSION;
		optionMap.put(ExtractorOption.PLATFORM_ZIP, platformZip);
	    }
	}
	return new GitMapper(services, optionMap);
    }

    public GitMapper(PlatformModuleManagerServices services, Map<CommandOption, String> optionMap) {
	this.vo = new GitMapVO(optionMap);
	this.overwrittenScripts = new ArrayList<>();
	this.prep = new GitMapPrep(services);
	this.fs = new FileServiceImpl();
    }

    /**
     * Performs the appropriate actions for module extraction
     */
    public void doMapping() throws SubCommandException {
	try {
	    prep.prepare(vo);
	    mapCustomObjectDesign();
	    mapFolders(vo.getUnzipDir(), vo.getPlatformDir());
	    if (vo.isOverwriteScripts() && overwrittenScripts.size() > 0) {
		printOverwrittenScripts();
	    }
	} catch (SubCommandException e) {
	    throw new SubCommandException("Exception when performing mapping!", e);
	}
    }

    /**
     * Map folder export to folder destination
     * 
     * @param exportedPlatform
     *            Folder where unzipped exported platform module is
     * @param destinationPlatform
     *            Folder where platform module is in local git directory
     * @throws PMExtractorException
     */
    private void mapFolders(File exportedPlatform, File destinationPlatform) throws PMExtractorException {
	GitMapVisitor visitor = new GitMapVisitor(vo, exportedPlatform.toPath(), destinationPlatform.toPath());
	try {
	    Files.walkFileTree(exportedPlatform.toPath(), visitor);
	    overwrittenScripts = visitor.getOverwrittenScripts();
	} catch (IOException e) {
	    throw new PMExtractorException("Exception when mapping the exportedPlatform", e);
	}
    }

    /**
     * In the exported unzipped platform module, move around the custom object
     * design scripts so they can be smoothly mapped 1=1 into git directory. This
     * method moves their location and removes $ from their names
     * 
     * @param path
     *            Path of Unzipped Exported platform module
     * @throws SubCommandException
     */
    private void mapCustomObjectDesign() throws SubCommandException {
	Path scriptsPath = vo.getUnzipDir().toPath().resolve(CUSTOM_OBJECT_MODULE).resolve(DESIGNS).resolve(SCRIPTS);
	if (!Files.exists(scriptsPath)) {
	    System.out.println("Cannot find script folder: " + scriptsPath.toString());
	    System.out.println("\tAssuming this module contains no scripts for custom objects.");
	    return;
	}
	File scripts = scriptsPath.toFile();
	for (File co : scripts.listFiles()) {
	    if (co.isDirectory()) {
		try {
		    fs.renameFile(co, co.getName().replace(SCRIPT_DESIGN + $, ""));
		} catch (IOException e) {
		    throw new SubCommandException("Exception when renaming script!", e);
		}
	    } else {
		String dirName = co.getName().replace(SCRIPT_DESIGN + $, "").replace(JS_EXTENSION, "");
		Path p = scriptsPath.resolve(dirName);
		try {
		    if (!Files.exists(p)) {
			Files.createDirectory(p);
		    }
		    Path destination = p.resolve(co.getName());
		    Files.move(co.toPath(), destination, REPLACE_EXISTING);
		} catch (IOException e) {
		    System.err.println("Failed to map custom object design: " + co.getName());
		}
	    }
	}
    }

    /**
     * Prints the scripts that were overwritten so the user can quickly noticed if
     * unwanted actions were performed on local git dir
     */
    private void printOverwrittenScripts() {
	final StringBuilder sb = new StringBuilder();
	System.out.print("You over wrote these scripts -> ");
	for (Path script : overwrittenScripts) {
	    if (sb.length() > 0) {
		sb.append("\n");
	    }
	    sb.append(script.toString());
	}
	System.out.println(sb.toString());
    }

}