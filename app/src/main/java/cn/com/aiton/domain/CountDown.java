package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.*;
/**
 * Created by Administrator on 14-2-16.
 */
@Table(name="CountDown")
public class CountDown {
    private int id;

    private int deviceId;

    private byte countDownId;

    private long phase;

    private int overlapPhase;

    private byte mode;

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

    public byte getCountDownId() {
        return countDownId;
    }

    public void setCountDownId(byte countDownId) {
        this.countDownId = countDownId;
    }

    public long getPhase() {
        return phase;
    }

    public void setPhase(long phase) {
        this.phase = phase;
    }

    public int getOverlapPhase() {
        return overlapPhase;
    }

    public void setOverlapPhase(int overlapPhase) {
        this.overlapPhase = overlapPhase;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }
}
