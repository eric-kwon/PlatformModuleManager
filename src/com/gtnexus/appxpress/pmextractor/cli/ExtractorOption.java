package com.gtnexus.appxpress.pmextractor.cli;

import com.gtnexus.appxpress.cli.AppXpressOption;
import com.gtnexus.appxpress.cli.OptionMessageProvider;
import com.gtnexus.appxpress.cli.ValidityProvider;

/**
 * Enumeration of options that can be stored in the Properties file or read in
 * from the CLI.
 */
public enum ExtractorOption implements AppXpressOption {

	HELP("h", "help", String.class, "Display usage for this tool", false, false, null), 
	PLATFORM_ZIP("pz", "platformZip", String.class,"Exported Platform Module Name", true, true, null), 
	LOCAL_DIR("ld", "localDir", String.class, "Relative Path of GIT staging folder",true, true, null), 
	CUSTOMER("c", "customer", String.class, "Customer of Platform Module", true, true, null), 
	PLATFORM("p", "platform", String.class, "Platform Module that is being exported", true, true, null), 
	OVERWRITE_SCRIPTS("os", "overwriteScripts", Boolean.class, "If Y -> overwriteScripts = true", true, false, "N"), 
	OVERWRITE_FEF("of", "overwriteFef", Boolean.class, "If Y -> overwriteFEF = true", true, false, "N");

	private final String flag;
	private final String longName;
	private final Class<?> type;
	private final boolean hasArg;
	private final boolean isMandatory;
	private final String defaultValue;
	private final String description;
	private static final OptionMessageProvider msgProvider = new OptionMessageProvider();
	private static final ValidityProvider validityProvider = new ValidityProvider();

	/**
	 * 
	 * @param longName
	 *            The name of this ExtractorOption.
	 * @param type
	 *            The ExtractorOption type.
	 * @param description
	 * @param isMandatory
	 * @param defaulValue
	 */
	private ExtractorOption(String flag, String longName, Class<?> type, String description,
			boolean hasArg, boolean isMandatory, String defaulValue) {
		this.flag = flag;
		this.longName = longName;
		this.type = type;
		this.hasArg = hasArg;
		this.description = description;
		this.isMandatory = isMandatory;
		this.defaultValue = defaulValue;
	}

	@Override
	public String toString() {
		return longName;
	}

	public String getLongName() {
		return longName;
	}

	public Class<?> getType() {
		return type;
	}

	public String getMessage() {
		return msgProvider.getMessage(type, longName);
	}

	public String getDescription() {
		return description;
	}

	public boolean hasArg() {
		return hasArg;
	}

	public boolean isAppXpressMandatory() {
		return isMandatory;
	}

	public boolean shouldBeOmitted() {
		return !isMandatory && defaultValue == null;
	}

	/**
	 * @return the default value for non-mandatory options.
	 * @throws java.lang.UnsupportedOperationException
	 *             if this method is called on a mandatory option.
	 */
	public String getDefaultValue() {
		if (this.isMandatory) {
			throw new UnsupportedOperationException(this.longName
					+ " is a mandatory field, and must come from "
					+ "user args or properties. There is no default value.");
		}
		return defaultValue;
	}

	/**
	 * Checks to see if the val supplies is a valid argument according to this
	 * option's type.
	 *
	 * @param val
	 * @return
	 */
	public boolean isValid(String val) {
		return validityProvider.isValid(val, type);
	}

	@Override
	public String getFlag() {
		return flag;
	}

	@Override
	public boolean isStoreableProperty() {
		if(this == LOCAL_DIR) {
			return true;
		}
		return false;
	}

}
