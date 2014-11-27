package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "GbtStagePattern")
public class GbtStagePattern {

    private int id;

	private int deviceId;

	private byte stagePatternId;

	private byte stageId;

	private int allowPhase;

	private byte greenTime;

	private byte yellowTime;

	private byte redTime;

	private byte option;

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

    public byte getStagePatternId() {
        return stagePatternId;
    }

    public void setStagePatternId(byte stagePatternId) {
        this.stagePatternId = stagePatternId;
    }

    public byte getStageId() {
        return stageId;
    }

    public void setStageId(byte stageId) {
        this.stageId = stageId;
    }

    public int getAllowPhase() {
        return allowPhase;
    }

    public void setAllowPhase(int allowPhase) {
        this.allowPhase = allowPhase;
    }

    public byte getGreenTime() {
        return greenTime;
    }

    public void setGreenTime(byte greenTime) {
        this.greenTime = greenTime;
    }

    public byte getYellowTime() {
        return yellowTime;
    }

    public void setYellowTime(byte yellowTime) {
        this.yellowTime = yellowTime;
    }

    public byte getRedTime() {
        return redTime;
    }

    public void setRedTime(byte redTime) {
        this.redTime = redTime;
    }

    public byte getOption() {
        return option;
    }

    public void setOption(byte option) {
        this.option = option;
    }
}
