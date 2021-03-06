package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class StagesTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldReturnNullPointer() {
        Stages env = new Stages();
        env.add(null);
        // intentionally no assert..cause we expect to get an exception.
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
        Stages env = new Stages();
        assertThat(env.getStages()).hasSize(0);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldReturnNullPointerExceptionInCaseOfGivingNull() {
        Stages env = new Stages();
        env.getStage(null);
        // intentionally no assert..cause we expect to get an exception.
    }

    @Test
    public void shouldReturnUnkonwnStageCauseNothingSetBefore() {
        Stages env = new Stages();
        assertThat(env.getStage("dev-2")).isEqualTo(Stage.UNKNOWN_STAGE);
    }

}
