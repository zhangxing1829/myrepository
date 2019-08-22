package com.bjc.entity;

import lombok.Data;

@Data
public class RestOverTime {

    /**
     * 调休开始时间
     */
    private String  startTime;

    /**
     * 调休结束时间
     */
    private String  endTime;

    /**
     * 调休总时长
     */
    private Double restTime;

    /**
     * 申请调休时间
     */
    private Double applyRestTime;

    /**
     * 调休原因
     */
    private String reason;

    /**
     * 调休月份
     */
    private String month;

    /**
     * 调休年月
     */
    private String year;


    /**
     * 加班总时长
     */
    private Double overTime;


    private Integer rStatus;

    private User user;

    @Override
    public String toString() {
        return "RestOverTime{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", restTime=" + restTime +
                ", applyRestTime=" + applyRestTime +
                ", reason='" + reason + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", overTime=" + overTime +
                ", rStatus=" + rStatus +
                ", user=" + user +
                '}';
    }


}
