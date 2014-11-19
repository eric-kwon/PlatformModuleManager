package com.gtnexus.appxpress.pmbuilder.bundle.platform;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.gtnexus.appxpress.AppXpressDirResolver;
import com.gtnexus.appxpress.AppXpressException;
import com.gtnexus.appxpress.Mapper;
import com.gtnexus.appxpress.Preparation;
import com.gtnexus.appxpress.file.FileService;
import com.gtnexus.appxpress.pmbuilder.AppXpressMapper;
import com.gtnexus.appxpress.pmbuilder.cli.PMBuilderVO;
import com.gtnexus.appxpress.pmbuilder.design.CustomObjectDesignXML;
import com.gtnexus.appxpress.pmbuilder.exception.PMBuilderException;
import com.gtnexus.appxpress.pmbuilder.scriptimport.ImportService;

public class BuildPrep implements Preparation<PMBuilderVO> {

	private final FileService fs;
	private final AppXpressDirResolver resolver;

	public BuildPrep() {
		this.fs = new FileService();
		this.resolver = new AppXpressDirResolver();
	}

	@Override
	public void prepare(final PMBuilderVO vo) throws PMBuilderException {
		try {
			File tmp = createTemp(vo);
			vo.setWorkingDir(tmp);
			runImportFind(tmp);
			xmlDesignCustomObjectScriptMatcher(tmp);
			map(tmp);
		} catch (AppXpressException | IOException e) {
			throw new PMBuilderException(
					"Exception when mapping file structure.", e);
		}
	}

	private File createTemp(final PMBuilderVO vo) throws IOException {
		Path source = vo.getRootFile().toPath();
		Path tmpPath = resolver
				.resolveAppXpressDir()
				.toAbsolutePath();
		String tmpPrefix = String.valueOf(System.currentTimeMillis());
		Path destination = Files
				.createTempDirectory(tmpPath, tmpPrefix);
		File dest = destination.toFile();
		dest.deleteOnExit();
		fs.copyDirectory(source, destination);
		return dest;
	}

	/**
	 * Iterates through folder customer/customer/folder
	 * 
	 * @param customer
	 *            Name of customer folder
	 * @param folder
	 *            Name of platform module folder
	 * @throws AppXpressException
	 */
	private void runImportFind(File rootFile) throws AppXpressException {
		System.out.println("Gathering imports...");
		ImportService iScanner = new ImportService(rootFile);
		iScanner.scanAndImport();
	}

	/**
	 * Searches through the custom object module folder and ensures that each
	 * custom object design xml file corresponds to the correct number of custom
	 * object scripts
	 */
	private void xmlDesignCustomObjectScriptMatcher(File rootFile)
			throws PMBuilderException {
		CustomObjectDesignXML coDes = new CustomObjectDesignXML(rootFile);
		coDes.ensureSoundDesign();
	}

	/**
	 * Maps pulled platform module to a file structure that can be imported onto
	 * GTNexus system
	 * 
	 * @param root
	 *            File path of platform module
	 */
	private void map(File rootFile) throws AppXpressException {
		Mapper mapper = new AppXpressMapper(rootFile);
		mapper.doMapping();
	}

}
