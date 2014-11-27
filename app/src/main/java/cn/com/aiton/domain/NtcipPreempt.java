package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "NtcipPreempt")
public class NtcipPreempt {

    private Long id;

    private Long deviceId;

    private int maxPreempts;

    private Long preemptTable;

    private Long preemptControlTable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public int getMaxPreempts() {
        return maxPreempts;
    }

    public void setMaxPreempts(int maxPreempts) {
        this.maxPreempts = maxPreempts;
    }

    public Long getPreemptTable() {
        return preemptTable;
    }

    public void setPreemptTable(Long preemptTable) {
        this.preemptTable = preemptTable;
    }

    public Long getPreemptControlTable() {
        return preemptControlTable;
    }

    public void setPreemptControlTable(Long preemptControlTable) {
        this.preemptControlTable = preemptControlTable;
    }
}
