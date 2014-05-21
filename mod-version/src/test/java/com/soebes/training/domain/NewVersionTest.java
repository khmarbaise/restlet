package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewVersionTest {

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
            String expectedClassifier, String expectedExtension) {
        String createdVersion = expectedArtifact + "-" + expectedVersion
                + (expectedClassifier == NO_CLASSIFIER ? "" : "-" + expectedClassifier) + "." + expectedExtension;
        NewVersion version = new NewVersion(createdVersion);
        assertThat(version.getArtifact()).isEqualTo(expectedArtifact);
        assertThat(version.getVersion()).isEqualTo(expectedVersion);
        assertThat(version.getClassifier()).isEqualTo(expectedClassifier);
        assertThat(version.getExtension()).isEqualTo(expectedExtension);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        new NewVersion("anton");
        // intentionally no assert() cause we expect to get an exception.
    }
}
