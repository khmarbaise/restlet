package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import java.text.ParseException;

import org.testng.annotations.Test;

public class NexusDateTest {

    @Test
    public void shouldParseNexusDateWithoutFail() throws ParseException {
        String nexusDate = "20140512.114557";
        NexusDate nd = new NexusDate(nexusDate);

        assertThat(nd.getYear()).isEqualTo(2014);
        assertThat(nd.getMonth()).isEqualTo(5);
        assertThat(nd.getDay()).isEqualTo(12);
        assertThat(nd.getHour()).isEqualTo(11);
        assertThat(nd.getMinute()).isEqualTo(45);
        assertThat(nd.getSeconds()).isEqualTo(57);
    }

}
