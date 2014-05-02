package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class StageTest {

    @Test
    public void setBuildShouldReturnItself() {
	Stage env = new Stage();
	assertThat(env.setBuild(12)).isSameAs(env);
    }

    @Test
    public void setVersionBuildShouldReturnItself() {
	Stage env = new Stage();
	assertThat(env.setVersion("12")).isSameAs(env);
    }
}
