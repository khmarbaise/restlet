package com.soebes.training.domain;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version {

    private static final String SNAPSHOT = "-SNAPSHOT";
    private String version;
    
    private int nexusCounter;
    private String extension;

    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\d+)(\\.(\\d+)(\\.(\\d+))?)?(\\-(.*))?",
	    Pattern.CASE_INSENSITIVE);

    private static final Pattern VERSION_NEXUS_PATTERN = Pattern.compile(
	    "\\-(\\d{4})(\\d{2})(\\d{2})\\.(\\d{2})(\\d{2})(\\d{2})\\-(\\d+)\\.((.*))$", Pattern.CASE_INSENSITIVE);

    public Version() {
    }

    private boolean snapshot;

    private boolean nexusVersion(String version) {
	boolean result = false;
	Matcher matcher = VERSION_NEXUS_PATTERN.matcher(version);
	if (matcher.matches()) {
	    result = true;

	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, Integer.valueOf(matcher.group(1)));
	    cal.set(Calendar.MONTH, Integer.valueOf(matcher.group(2)));
	    cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(matcher.group(3)));
	    cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(matcher.group(4)));
	    cal.set(Calendar.MINUTE, Integer.valueOf(matcher.group(5)));
	    cal.set(Calendar.SECOND, Integer.valueOf(matcher.group(6)));
	    cal.setTimeZone(TimeZone.getTimeZone("UTC"));
	    
	    this.nexusCounter = Integer.valueOf(matcher.group(7));
	    this.extension = matcher.group(8);
	}
	return result;
    }

    public Version(String version) {
	this.version = version;
	
	if (VERSION_NEXUS_PATTERN.matcher(version).matches()) {
	    //Nexus.
//	} else if () {
//	    
	}

	Matcher matcher = VERSION_PATTERN.matcher(version);
	if (matcher.matches()) {
	    if (matcher.group(1) != null) {
		// setMajor(Integer.valueOf(matcher.group(1)));
	    }
	    if (matcher.group(3) != null) {
		// setMinor(Integer.valueOf(matcher.group(3)));
	    }
	    if (matcher.group(5) != null) {
		// setPatch(Integer.valueOf(matcher.group(5)));
	    }
	    if (matcher.group(6) != null && matcher.group(6).equals(SNAPSHOT)) {
		// setSnapshot(true);
	    } else {
		// setQualifier(matcher.group(7));
	    }
	} else {
	    throw new IllegalArgumentException("The version '" + version + "' does not match the pattern x.y.z or x.y.z-SNAPSHOT!");
	}

    }

    public boolean isSnapshot() {
	if (this.version.endsWith(SNAPSHOT)) {
	    return true;
	} else {
	    return false;
	}
    }
}
