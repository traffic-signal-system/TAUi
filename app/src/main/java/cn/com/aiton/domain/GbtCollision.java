package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;

@Table(name = "GbtCollision")
public class GbtCollision {

    private int id;

	private int deviceId;

	private byte phaseId;

	private int flag;

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

    public byte getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(byte phaseId) {
        this.phaseId = phaseId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
