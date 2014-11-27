package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "GbtDetector")
public class GbtDetector {

    private int id;

	private int deviceId;

	private byte detectorId;

	private byte phaseId;

	private byte detectorType;

	private byte direc;

	private byte requestEffectTime;

	private byte detectorOption;

	private short saturationVolume;

	private byte saturationOccupancy;

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

    public byte getDetectorId() {
        return detectorId;
    }

    public void setDetectorId(byte detectorId) {
        this.detectorId = detectorId;
    }

    public byte getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(byte phaseId) {
        this.phaseId = phaseId;
    }

    public byte getDetectorType() {
        return detectorType;
    }

    public void setDetectorType(byte detectorType) {
        this.detectorType = detectorType;
    }

    public byte getDirec() {
        return direc;
    }

    public void setDirec(byte direc) {
        this.direc = direc;
    }

    public byte getRequestEffectTime() {
        return requestEffectTime;
    }

    public void setRequestEffectTime(byte requestEffectTime) {
        this.requestEffectTime = requestEffectTime;
    }

    public byte getDetectorOption() {
        return detectorOption;
    }

    public void setDetectorOption(byte detectorOption) {
        this.detectorOption = detectorOption;
    }

    public short getSaturationVolume() {
        return saturationVolume;
    }

    public void setSaturationVolume(short saturationVolume) {
        this.saturationVolume = saturationVolume;
    }

    public byte getSaturationOccupancy() {
        return saturationOccupancy;
    }

    public void setSaturationOccupancy(byte saturationOccupancy) {
        this.saturationOccupancy = saturationOccupancy;
    }
}
