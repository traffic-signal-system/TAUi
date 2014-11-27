package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "GbtGroupTimeBase")
public class GbtGroupTimeBase {

    private int id;

	private int groupId;

	private byte timeBaseId;

	private int month;

	private short week;

	private long day;

	private byte scheduleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public byte getTimeBaseId() {
        return timeBaseId;
    }

    public void setTimeBaseId(byte timeBaseId) {
        this.timeBaseId = timeBaseId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public short getWeek() {
        return week;
    }

    public void setWeek(short week) {
        this.week = week;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public byte getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(byte scheduleId) {
        this.scheduleId = scheduleId;
    }
}
