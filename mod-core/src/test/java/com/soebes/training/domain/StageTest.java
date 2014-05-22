package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class StageTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowExceptionCauseVersionIsNull() {
        Stage env = new Stage();
        env.setVersion(null);
        // intentionally no assert... cause we except to get an exception.
    }

    @Test
    public void setVersionBuildShouldReturnItself() {
        Stage env = new Stage();
        assertThat(env.setVersion("12")).isSameAs(env);
    }

}
