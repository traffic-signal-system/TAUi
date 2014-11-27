package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "GbtGroupSchedule")
public class GbtGroupSchedule {

    private int id;

	private int groupId;

	private byte scheduleId;

	private byte eventId;

	private byte beginHour;

	private byte beginMinute;

	private byte timePatternId;

	private byte controlMode;

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

    public byte getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(byte scheduleId) {
        this.scheduleId = scheduleId;
    }

    public byte getEventId() {
        return eventId;
    }

    public void setEventId(byte eventId) {
        this.eventId = eventId;
    }

    public byte getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(byte beginHour) {
        this.beginHour = beginHour;
    }

    public byte getBeginMinute() {
        return beginMinute;
    }

    public void setBeginMinute(byte beginMinute) {
        this.beginMinute = beginMinute;
    }

    public byte getTimePatternId() {
        return timePatternId;
    }

    public void setTimePatternId(byte timePatternId) {
        this.timePatternId = timePatternId;
    }

    public byte getControlMode() {
        return controlMode;
    }

    public void setControlMode(byte controlMode) {
        this.controlMode = controlMode;
    }
}
