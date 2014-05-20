package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewVersionTest {

    @DataProvider
    public Object[][] getVersions() {
	//@formatter:off
	return new String[][] {
		{ "A-1.jar" },
		{ "A-1.2.jar" },
		{ "A-1.2.3.jar" },
		{ "A-1.2.3.4.jar" },
		{ "A-1.2.3.4.5.jar" },
		{ "A-1.12.123.1234.12345.1234567.12345678.123456789.jar" },
		{ "A-2.16.0.1.jar" },
		{ "first-ear-1.2.3.4.5.jar" },
		{ "xyz-abc-1.2.3.jar" },
		{ "xyz-abc-1.2.3.45.jar" },
		{ "xyz-abc-1.2.3.45.600.jar" },
		{ "A-1-sources.jar" },
		{ "A-1.2-test-jar.jar" },
		{ "first-1.2-test-jar.tar.gz" },
		{ "anton-1.2.4.5.tar.gz" },
	};
	//@formatter:on
    }

    private static final Pattern VERSION_PATTERN = Pattern.compile("(.*)"
    	+ "\\-((\\d+)(\\.(\\d+))*)"
    	+ "(\\-(.+)?)?"
//    	+ "(?<=\\.).*$"
    	+ "\\.(.+)(\\.(.+))*$",
	    Pattern.CASE_INSENSITIVE);

    @Test(dataProvider = "getVersions")
    public void xTest(String version) {
	Matcher matcher = VERSION_PATTERN.matcher(version);
	assertThat(matcher.matches()).isTrue();
	System.out.println("-- Version: " + version);
	System.out.println("  Groups:" + matcher.groupCount());
	for (int i = 0; i < matcher.groupCount(); i++) {
	    System.out.println("  Group[" + i + "]=" + matcher.group(i));
	}
    }

}
