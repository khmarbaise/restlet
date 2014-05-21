package com.soebes.training.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewVersion {

    //@formatter:off
    private static final Pattern VERSION_PATTERN = Pattern.compile("(.*)" 
        + "\\-((\\d+)(\\.(\\d+))*)" 
        + "(\\-([^.]+))?" // Classifier
        + "\\.((.+)(\\.(.+))*)$", // Extension .tar.gz ?
        Pattern.CASE_INSENSITIVE);
    //@formatter:on

    private String version;
    private String classifier;
    private String extension;
    private String artifact;

    public NewVersion(String version) {
        Matcher matcher = VERSION_PATTERN.matcher(version);
        if (matcher.matches()) {
            this.artifact = matcher.group(1);
            this.version = matcher.group(2);
            this.classifier = matcher.group(7);
            this.extension = matcher.group(9);
            //
        } else {
            throw new IllegalArgumentException("The format of the version does not match.");
        }

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

}
