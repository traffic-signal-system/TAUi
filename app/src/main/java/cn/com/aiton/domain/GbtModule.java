package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "GbtModule")
public class GbtModule {

    private int id;

	private int deviceId;

	private byte moduleId;

	private String deviceNode;

	private String factory;

	private String model;

	private String version;

	private byte type;

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

    public byte getModuleId() {
        return moduleId;
    }

    public void setModuleId(byte moduleId) {
        this.moduleId = moduleId;
    }

    public String getDeviceNode() {
        return deviceNode;
    }

    public void setDeviceNode(String deviceNode) {
        this.deviceNode = deviceNode;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
