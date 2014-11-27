package cn.com.aiton.domain;

import net.tsz.afinal.annotation.sqlite.Table;


@Table(name = "NtcipDayPlan")
public class NtcipDayPlan {

    private Long id;

    private Long deviceId;

    private Long maxDayPlans;

    private Long maxDayPlanEvents;

    private Long timeBaseDayPlanTable;

    private Long dayPlanStatus;


}
