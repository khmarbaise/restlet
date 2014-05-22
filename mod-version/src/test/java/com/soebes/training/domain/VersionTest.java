package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VersionTest {
    private static final Pattern MAJOR_MINOR_PATCH_PATTERN = Pattern.compile(
            "(\\d+)(\\.(\\d+))?(\\.(\\d+))?(\\.(\\d+))?(\\.(\\d+))?", Pattern.CASE_INSENSITIVE);

    private static final Pattern VERSION_PATTERN = Pattern.compile("(.*)\\-(\\d+)(\\.(\\d+)(\\.(\\d+))?)?(\\-(.*))?",
            Pattern.CASE_INSENSITIVE);

    // private static final Pattern SNAPSHOT_VERSION_PATTERN =
    // Pattern.compile("\\-SNAPSHOT\\.((.*))$");
    private static final Pattern SNAPSHOT_VERSION_PATTERN = Pattern.compile("(.*)" + "\\-" + "(" + Pattern.quote("SNAPSHOT") + ")"
            + "\\.((.*))$");

    private static final Pattern VERSION_NEXUS_PATTERN = Pattern
            .compile("(.*)\\-(\\d{4})(\\d{2})(\\d{2})\\.(\\d{2})(\\d{2})(\\d{2})\\-(\\d+)\\.((.*))$");

    @DataProvider
    public Object[][] getVersions() {
        //@formatter:off
	return new String[][] {
		{ "A-1.2.3-SNAPSHOT.jar" },
		{ "xyz-abc-1.2.3-20140516.123456-12.jar" },
	};
	//@formatter:on
    }

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

    @DataProvider
    public Object[][] getNexusVersions() {
        //@formatter:off
	return new String[][] {
		{ "A-1.2.3-20140526.123456-1.jar" },
		{ "XYZ-egon-2.4.5.16-20140526.123456-12.jar" },
		{ "first-artifact-1.2-20140516.123456-34342.jar" },
		{ "the-first-artifacts-20131216.024555-137.tar.gz" },
	};
	//@formatter:on
    }

    @Test(dataProvider = "getNexusVersions")
    public void shouldNexusVersion(String nexusVersions) {
        Matcher matcher = VERSION_NEXUS_PATTERN.matcher(nexusVersions);
        assertThat(matcher.matches()).isTrue();
        assertThat(matcher.groupCount()).isEqualTo(10);
        System.out.println("-- NexusVersion: " + nexusVersions);
        System.out.println("  Groups:" + matcher.groupCount());
        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println("  Group[" + i + "]=" + matcher.group(i));
        }
    }

    @DataProvider
    public Object[][] getSnapshotVersions() {
        //@formatter:off
	return new String[][] {
		{ "A-1-SNAPSHOT.jar" },
		{ "A-1.2-SNAPSHOT.jar" },
		{ "A-1.2.3-SNAPSHOT.jar" },
		{ "TheFirstArtifact-second-1.2.3.4-SNAPSHOT.jar" },
		{ "xyz-abc-1.2.3-SNAPSHOT.jar" },
		{ "xyz-abc-1.2.3-SNAPSHOT.zip" },
		{ "xyz-abc-1.2.3-SNAPSHOT.tar.gz" },
	};
	//@formatter:on
    }

    @Test(dataProvider = "getSnapshotVersions")
    public void shouldSnapshotVersion(String snapshotVersions) {
        Matcher matcher = SNAPSHOT_VERSION_PATTERN.matcher(snapshotVersions);
        assertThat(matcher.matches()).isTrue();
        // assertThat(matcher.groupCount()).isEqualTo(9);
        System.out.println("-- SnapshotVersion: " + snapshotVersions);
        System.out.println("  Groups:" + matcher.groupCount());
        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println("  Group[" + i + "]=" + matcher.group(i));
        }
    }

    @DataProvider
    public Object[][] getMajorMinorPatchVersions() {
        //@formatter:off
	return new String[][] {
		{ "1" },
		{ "1.2" },
		{ "1.2.3" },
		{ "1.2.3.4" },
		{ "1.2.3.4.5" },
	};
	//@formatter:on
    }

    @Test(dataProvider = "getMajorMinorPatchVersions")
    public void shouldMajorMinorPatchVersion(String versions) {
        Matcher matcher = MAJOR_MINOR_PATCH_PATTERN.matcher(versions);
        assertThat(matcher.matches()).isTrue();
        System.out.println("-- MajorMinorPatchVersions: " + versions);
        System.out.println("  Groups:" + matcher.groupCount());
        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println("  Group[" + i + "]=" + matcher.group(i));
        }
    }

}
