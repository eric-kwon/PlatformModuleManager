package com.gtnexus.appxpress;

import static com.gtnexus.appxpress.AppXpressConstants.dirTemplate;

import java.io.File;
import java.nio.file.Path;

public class AppXpressDirResolver {
	
	 private static final String USER_HOME = "user.home";
	 private final String homeDir;
	 private final File appXpressDir;
	 
	 public AppXpressDirResolver() {
		 this.homeDir = System.getProperty(USER_HOME);
		 this.appXpressDir = new File(String.format(dirTemplate, this.homeDir));
	 }
	 
	 public Path resolveAppXpressDir() {
		return appXpressDir.toPath();
	 }

}
