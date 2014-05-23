package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VersionTest {

    public static final String NO_CLASSIFIER = null;

    @DataProvider
    public Object[][] getVersions() {
        //@formatter:off
		return new String[][] {
			{ "A",         "1",                                              NO_CLASSIFIER,  "jar"  },
			{ "A",         "1.2",                                            NO_CLASSIFIER,  "jar"   },
			{ "A",         "1.2.3",                                          NO_CLASSIFIER,  "jar"   },
			{ "A",         "1.2.3.4",                                        NO_CLASSIFIER,  "jar"  },
			{ "A",         "1.2.3.4.5",                                      NO_CLASSIFIER,  "jar"   },
			{ "A",         "1.12.123.1234.12345.1234567.12345678.123456789", NO_CLASSIFIER,  "jar"   },
			{ "A",         "2.16.0.1",                                       NO_CLASSIFIER,  "jar"   },
			{ "first-ear", "1.2.3.4.5",                                      NO_CLASSIFIER,  "jar"   },
			{ "xyz-abc",   "1.2.3",                                          NO_CLASSIFIER,  "jar"   },
			{ "xyz-abc",   "1.2.3.45",                                       NO_CLASSIFIER,  "jar"   },
			{ "xyz-abc",   "1.2.3.45.600",                                   NO_CLASSIFIER,  "jar"   },
			{ "A",         "1",                                              "sources",      "jar" },
			{ "A",         "1.2",                                            "test-jar",     "jar"  },
			{ "first",     "1.2",                                            "test-jar",     "tar.gz"  },
			{ "first",     "1.2",                                            "test-jar",     "anton.egon.friedhelm.gz"   },
			{ "first",     "1.2",                                            "test-jar",     "tar"  },
			{ "first",     "1.2",                                            "test-jar",     "tar.bz2"  },
			{ "first",     "1.2",                                            "test-jar",     "zip"  },
			{ "anton",     "1.2.4.5",                                        NO_CLASSIFIER,  "tar.gz"  },
		};
   		//@formatter:on
    }

    @Test(dataProvider = "getVersions")
    public void shouldParseAllGivenVersionsWithoutFailure(String expectedArtifact, String expectedVersion,
            String expectedClassifier, String expectedExtension) throws ParseException {
        
        String createdVersion = expectedArtifact + "-" + expectedVersion
                + (expectedClassifier == NO_CLASSIFIER ? "" : "-" + expectedClassifier) + "." + expectedExtension;

        Version version = new Version(createdVersion);
        assertThat(version.getArtifact()).isEqualTo(expectedArtifact);
        assertThat(version.getVersion()).isEqualTo(expectedVersion);
        assertThat(version.getClassifier()).isEqualTo(expectedClassifier);
        assertThat(version.getExtension()).isEqualTo(expectedExtension);
        assertThat(version.isSnapshot()).isFalse();
        assertThat(version.isRelease()).isTrue();
    }

    @Test(dataProvider = "getVersions")
    public void shouldParseAllGivenSnapshotVersionsWithoutFailure(String expectedArtifact, String expectedVersion,
            String expectedClassifier, String expectedExtension) throws ParseException {
        
        String constructedVersion = expectedArtifact + "-" + expectedVersion + "-SNAPSHOT"
                + (expectedClassifier == NO_CLASSIFIER ? "" : "-" + expectedClassifier) + "." + expectedExtension;
        
        Version version = new Version(constructedVersion);

        assertThat(version.getArtifact()).isEqualTo(expectedArtifact);
        assertThat(version.getVersion()).isEqualTo(expectedVersion);
        assertThat(version.getClassifier()).isEqualTo(expectedClassifier);
        assertThat(version.getExtension()).isEqualTo(expectedExtension);
        assertThat(version.isSnapshot()).isTrue();

    }

    @Test(dataProvider = "getVersions")
    public void shouldParseAllGivenNexusVersionsWithoutFailure(String expectedArtifact, String expectedVersion,
            String expectedClassifier, String expectedExtension) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.HHmmss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.set(Calendar.YEAR, 2014);
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.DAY_OF_MONTH, 20);
        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 34);
        cal.set(Calendar.SECOND, 57);
        
        String nexusDate = sdf.format(cal.getTime());
        Random r = new Random(System.currentTimeMillis());
        int nextInt = r.nextInt(2048);

        String constructedVersion = expectedArtifact + "-" + expectedVersion + "-" + nexusDate + "-" + nextInt
                + (expectedClassifier == NO_CLASSIFIER ? "" : "-" + expectedClassifier) + "." + expectedExtension;
        
        Version version = new Version(constructedVersion);

        assertThat(version.getArtifact()).isEqualTo(expectedArtifact);
        assertThat(version.getVersion()).isEqualTo(expectedVersion);
        assertThat(version.getClassifier()).isEqualTo(expectedClassifier);
        assertThat(version.getExtension()).isEqualTo(expectedExtension);
        
        NexusDate resultNexusDate = version.getNexusDate();
        assertThat(resultNexusDate.getYear()).isEqualTo(2014);
        assertThat(resultNexusDate.getMonth()).isEqualTo(6);
        assertThat(resultNexusDate.getDay()).isEqualTo(20);
        assertThat(resultNexusDate.getHour()).isEqualTo(22);
        assertThat(resultNexusDate.getMinute()).isEqualTo(34);
        assertThat(resultNexusDate.getSeconds()).isEqualTo(57);
    }

    @Test
    public void check() throws ParseException {
        String version = "first-1.2-20140620.223457-1825-test-jar.anton.egon.friedhelm.gz";
        Version v = new Version(version);
        assertThat(v.getArtifact()).isEqualTo("first");
        assertThat(v.getVersion()).isEqualTo("1.2");
        assertThat(v.getClassifier()).isEqualTo("test-jar");
        assertThat(v.getExtension()).isEqualTo("anton.egon.friedhelm.gz");
        
        assertThat(v.getNexusCount()).isEqualTo(1825);
        NexusDate nexusDate = v.getNexusDate();
        assertThat(nexusDate.getYear()).isEqualTo(2014);
        assertThat(nexusDate.getMonth()).isEqualTo(06);
        assertThat(nexusDate.getDay()).isEqualTo(20);
        assertThat(nexusDate.getHour()).isEqualTo(22);
        assertThat(nexusDate.getMinute()).isEqualTo(34);
        assertThat(nexusDate.getSeconds()).isEqualTo(57);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() throws ParseException {
        new Version("anton");
        // intentionally no assert() cause we expect to get an exception.
    }

}
