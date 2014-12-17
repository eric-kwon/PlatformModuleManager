package com.gtnexus.appxpress.pmextractor.cli;

import com.gtnexus.appxpress.cli.option.CLIOption;


public class DummyOption implements CLIOption{

	@Override
	public String getLongName() {
		return "Dummy";
	}

	@Override
	public Class<?> getType() {
		return Object.class;
	}

	@Override
	public String getDescription() {
		return "Dummy";
	}

	@Override
	public boolean hasArg() {
		return false;
	}

	@Override
	public String getFlag() {
		return "dummyFlag";
	}

	@Override
	public boolean isHelpFlag() {
		// TODO Auto-generated method stub
		return false;
	}

}
