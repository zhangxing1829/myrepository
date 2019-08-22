package com.bjc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_bs_rest
 * @author 
 */
public class TblBsRest implements Serializable {
    private Integer restId;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 调休开始时间
     */
    private Date startTime;

    /**
     * 调休结束时间
     */
    private Date endTime;

    /**
     * 总调休时长
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

    private static final long serialVersionUID = 1L;

    public Integer getRestId() {
        return restId;
    }

    public void setRestId(Integer restId) {
        this.restId = restId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getRestTime() {
        return restTime;
    }

    public void setRestTime(Double restTime) {
        this.restTime = restTime;
    }

    public Double getApplyRestTime() {
        return applyRestTime;
    }

    public void setApplyRestTime(Double applyRestTime) {
        this.applyRestTime = applyRestTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}