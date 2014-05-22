package com.soebes.training.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class NexusDate {

    private static final TimeZone TIME_ZONE_UTC = TimeZone.getTimeZone("UTC");

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;

    private Date nexusDate;

    public NexusDate(String nexusDate) throws ParseException {
        checkNotNull(nexusDate, "Not allowed to use null for nexusDate.");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.HHmmss");
        sdf.setTimeZone(TIME_ZONE_UTC);

        Date parse = sdf.parse(nexusDate);
        setNexusDate(parse);

        Calendar cal = Calendar.getInstance(TIME_ZONE_UTC);
        cal.setTime(parse);

        setYear(cal.get(Calendar.YEAR));
        setMonth(cal.get(Calendar.MONTH) + 1);
        setDay(cal.get(Calendar.DAY_OF_MONTH));
        setHour(cal.get(Calendar.HOUR_OF_DAY));
        setMinute(cal.get(Calendar.MINUTE));
        setSeconds(cal.get(Calendar.SECOND));
    }

    public int getYear() {
        return year;
    }

    public NexusDate setYear(int year) {
        checkArgument(year > 0, "Year must be greater 0");
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public NexusDate setMonth(int month) {
        checkArgument(month > 0 && month <= 12, "Must must be in the range 1..12.");
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public NexusDate setDay(int day) {
        checkArgument(month > 0 && month <= 12, "Must must be in the range 1..12.");
        this.day = day;
        return this;
    }

    public int getHour() {
        return hour;
    }

    public NexusDate setHour(int hour) {
        checkArgument(hour > 0 && hour <= 31, "Must must be in the range 1..31.");
        this.hour = hour;
        return this;
    }

    public int getMinute() {
        return minute;
    }

    public NexusDate setMinute(int minute) {
        checkArgument(minute >= 0 && minute <= 59, "Must must be in the range 0..59.");
        this.minute = minute;
        return this;
    }

    public int getSeconds() {
        return seconds;
    }

    public NexusDate setSeconds(int seconds) {
        checkArgument(seconds >= 0 && seconds <= 59, "Must must be in the range 0..59.");
        this.seconds = seconds;
        return this;
    }

    public Date getNexusDate() {
        return nexusDate;
    }

    public NexusDate setNexusDate(Date nexusDate) {
        this.nexusDate = nexusDate;
        return this;
    }
}
