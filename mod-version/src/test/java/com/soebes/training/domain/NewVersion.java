package com.soebes.training.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewVersion {

    //@formatter:off
    private static final Pattern VERSION_PATTERN = Pattern.compile("(.*)" 
        + "\\-((\\d+)(\\.(\\d+))*)" 
        + "(\\-([^.]+))?" // Classifier
        + "\\.((.+)(\\.(.+))*)$", // Extension .tar.gz ?
        Pattern.CASE_INSENSITIVE
    );
    //@formatter:on

    //@formatter:off
    private static final Pattern SNAPSHOT_VERSION_PATTERN = Pattern.compile("(.*)" 
       + "\\-((\\d+)(\\.(\\d+))*)" 
       + "(\\-(" + Pattern.quote("SNAPSHOT") + "))?"
       + "(\\-([^.]+))?" // Classifier
       + "\\.((.+)(\\.(.+))*)$" // Extension .tar.gz ?
    ); 
    //@formatter:on

    private String version;
    private String classifier;
    private String extension;
    private String artifact;
    private boolean snapshot;

    public NewVersion(String version) {
        Matcher matcher = VERSION_PATTERN.matcher(version);
        Matcher matcherSnapshot = SNAPSHOT_VERSION_PATTERN.matcher(version);

        if (matcherSnapshot.matches()) {
            System.out.println("Groups:" + matcherSnapshot.groupCount());
            for (int i = 0; i < matcherSnapshot.groupCount(); i++) {
                System.out.println(" -> [" + i + "]=" + matcherSnapshot.group(i));
            }
            this.artifact = matcherSnapshot.group(1);
            this.version = matcherSnapshot.group(2);
    
            if (matcherSnapshot.group(7) == null ) {
                this.snapshot = false;
            } else {
                this.snapshot = true;
            }
            this.classifier = matcherSnapshot.group(9);
            this.extension = matcherSnapshot.group(11);
        } else if (matcher.matches()) {
            this.artifact = matcher.group(1);
            this.version = matcher.group(2);
            this.classifier = matcher.group(7);
            this.extension = matcher.group(9);
        } else {
            throw new IllegalArgumentException("The format of the version does not match.");
        }

    }

    public boolean hasClassifier() {
        return getClassifier() != null;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public boolean isSnapshot() {
        return snapshot;
    }

    public void setSnapshot(boolean snapshot) {
        this.snapshot = snapshot;
    }

}
