package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class StagesTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldReturnNullPointer() {
	Stages env = new Stages();
	env.add(null);
	//intentionally no assert..cause we expect to get an exception.
    }

    @Test
    public void shouldReturnSizeOne() {
	Stages env = new Stages();
	env.add("dev-1");
	assertThat(env.getStages()).hasSize(1);
    }

    @Test
    public void shouldReturnVersionWhichHasBeenSetBefore() {
	String version = "1.23.30-SNAPSHOT";
	Stages env = new Stages();
	env.add("dev-1").setVersion(version);
	assertThat(env.getStages()).hasSize(1);
	assertThat(env.getStages().get("dev-1").getVersion()).isEqualTo(version);
    }

    @Test
    public void shouldReturnBuildWhichHasBeenSetBefore() {
	int build = 2345;
	Stages env = new Stages();
	env.add("dev-1").setBuild(build);
	assertThat(env.getStages()).hasSize(1);
	assertThat(env.getStages().get("dev-1").getBuild()).isEqualTo(build);
    }

    @Test
    public void shouldReturnNothingCauseNotSetBefore() {
	Stages env = new Stages();
	assertThat(env.getStages()).hasSize(0);
	assertThat(env.getStages().get("dev-2")).isEqualTo(Stage.UNKNOWN_STAGE);
    }

}
