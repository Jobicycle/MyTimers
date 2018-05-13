package com.justin.mytimers.model;

public class StopWatch {
    public static final String TABLE = "Stopwatch";
    public final static String KEY_ID = "ID";
    public final static String KEY_NAME = "Name";
    public final static String KEY_START = "Start_Time";
    public final static String KEY_STOP = "Stop_Time";
    public final static String KEY_DURATION = "Duration";

    private String name;
    private long startTime;
    private long stopTime;
    private long duration;

    public StopWatch(String name, long startTime, long stopTime, long duration) {
        this.name = name;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.duration = duration;
    }

    public StopWatch() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
