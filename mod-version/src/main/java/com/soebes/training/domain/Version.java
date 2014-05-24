package com.soebes.training.domain;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version {

    //@formatter:off
    private static final Pattern VERSION_PATTERN = Pattern.compile("(.*?)" 
       + "\\-((\\d+)(\\.(\\d+))*)" 
       + "(\\-(\\d{4}\\d{2}\\d{2}\\.\\d{2}\\d{2}\\d{2})\\-(\\d+))?"
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
    private boolean release;
    private boolean nexus;
    private NexusDate nexusDate;
    private int nexusCount;

    public Version(String version) throws ParseException {
        Matcher matcher = VERSION_PATTERN.matcher(version);

        if (matcher.matches()) {
            this.snapshot = false;
            this.release = false;

            this.artifact = matcher.group(1);
            this.version = matcher.group(2);

            if (matcher.group(7) != null) {
                this.nexusDate = new NexusDate(matcher.group(7));
                this.nexus = true;
                this.nexusCount = Integer.valueOf(matcher.group(8));
            }

            if (matcher.group(10) == null && matcher.group(7) == null) {
                this.release = true;
            } else {
                this.snapshot = true;
            }
            
            this.classifier = matcher.group(12);
            this.extension = matcher.group(14);
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

    public boolean isRelease() {
        return release;
    }

    public void setRelease(boolean release) {
        this.release = release;
    }

    public boolean isNexus() {
        return nexus;
    }

    public void setNexus(boolean nexus) {
        this.nexus = nexus;
    }

    public NexusDate getNexusDate() {
        return nexusDate;
    }

    public void setNexusDate(NexusDate nexusDate) {
        this.nexusDate = nexusDate;
    }

    public int getNexusCount() {
        return nexusCount;
    }

    public void setNexusCount(int nexusCount) {
        this.nexusCount = nexusCount;
    }

}
