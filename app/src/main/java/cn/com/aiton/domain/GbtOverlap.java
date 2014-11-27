package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


import java.util.List;
@Table(name = "GbtOverlap")
public class GbtOverlap {
    private int id;

	private int deviceId;

	private byte overlapId;

	private byte overlapType;

	private byte includePhaseCount;

	private String includePhase;

	private byte amendPhaseCount;

	private String amendPhase;

    private byte tailGreen;

    private byte tailYellow;

    private byte tailRed;

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

    public byte getOverlapId() {
        return overlapId;
    }

    public void setOverlapId(byte overlapId) {
        this.overlapId = overlapId;
    }

    public byte getOverlapType() {
        return overlapType;
    }

    public void setOverlapType(byte overlapType) {
        this.overlapType = overlapType;
    }

    public byte getIncludePhaseCount() {
        return includePhaseCount;
    }

    public void setIncludePhaseCount(byte includePhaseCount) {
        this.includePhaseCount = includePhaseCount;
    }

    public String getIncludePhase() {
        return includePhase;
    }

    public void setIncludePhase(String includePhase) {
        this.includePhase = includePhase;
    }

    public byte getAmendPhaseCount() {
        return amendPhaseCount;
    }

    public void setAmendPhaseCount(byte amendPhaseCount) {
        this.amendPhaseCount = amendPhaseCount;
    }

    public String getAmendPhase() {
        return amendPhase;
    }

    public void setAmendPhase(String amendPhase) {
        this.amendPhase = amendPhase;
    }

    public byte getTailGreen() {
        return tailGreen;
    }

    public void setTailGreen(byte tailGreen) {
        this.tailGreen = tailGreen;
    }

    public byte getTailYellow() {
        return tailYellow;
    }

    public void setTailYellow(byte tailYellow) {
        this.tailYellow = tailYellow;
    }

    public byte getTailRed() {
        return tailRed;
    }

    public void setTailRed(byte tailRed) {
        this.tailRed = tailRed;
    }
}
