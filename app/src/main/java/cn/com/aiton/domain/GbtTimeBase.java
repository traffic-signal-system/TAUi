package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "GbtTimeBase")
public class GbtTimeBase {

    private int id;

	private int deviceId;

	private byte timeBaseId;

	private short month;

	private byte week;

	private int day;

	private byte scheduleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public byte getTimeBaseId() {
        return timeBaseId;
    }

    public void setTimeBaseId(byte timeBaseId) {
        this.timeBaseId = timeBaseId;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public byte getWeek() {
        return week;
    }

    public void setWeek(byte week) {
        this.week = week;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public byte getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(byte scheduleId) {
        this.scheduleId = scheduleId;
    }
}
