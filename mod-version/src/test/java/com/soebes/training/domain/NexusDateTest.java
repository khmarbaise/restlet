package com.soebes.training.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import java.text.ParseException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NexusDateTest {

    public class NexusDateRangeTests {

        private NexusDate nd;

        @BeforeMethod
        public void beforeMethod() throws ParseException {
            nd = new NexusDate("20140512.114557");
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setYearShouldThrowIllegalArgumentException() throws ParseException {
            nd.setYear(0);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setMonthShouldThrowIllegalArgumentException() throws ParseException {
            nd.setMonth(0);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setDayLowerShouldThrowIllegalArgumentException() throws ParseException {
            nd.setDay(0);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setDayMaxShouldThrowIllegalArgumentException() throws ParseException {
            nd.setDay(32);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setHourMinShouldThrowIllegalArgumentException() throws ParseException {
            nd.setHour(0);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setHourMaxShouldThrowIllegalArgumentException() throws ParseException {
            nd.setHour(24);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setMinuteMinShouldThrowIllegalArgumentException() throws ParseException {
            nd.setMinute(-1);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setMinuteMaxShouldThrowIllegalArgumentException() throws ParseException {
            nd.setMinute(60);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setSecondsMinShouldThrowIllegalArgumentException() throws ParseException {
            nd.setSeconds(-1);
        }

        @Test(expectedExceptions = IllegalArgumentException.class)
        public void setSecondsMaxShouldThrowIllegalArgumentException() throws ParseException {
            nd.setSeconds(60);
        }

    }

    @Test(expectedExceptions = NullPointerException.class)
    public void ctorShouldThrowNullPointerExceptionCauseMissingArgument() throws ParseException {
        @SuppressWarnings("unused")
        NexusDate nd = new NexusDate(null);
        //intentionally no assert, cause expecting an exception.
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void setNexusDateShouldThrowNullPointerExceptionCauseMissingArgument() throws ParseException {
        NexusDate nd = new NexusDate("20140512.114557");
        nd.setNexusDate(null);
        //intentionally no assert, cause expecting an exception.
    }

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
