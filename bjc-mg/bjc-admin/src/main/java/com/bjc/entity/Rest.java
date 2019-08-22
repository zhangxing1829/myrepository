package com.bjc.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_bs_rest
 * @author 
 */
@Data
@TableName("tbl_bs_rest")
public class Rest implements Serializable {


    private String number;
    private  String name;
    private String applyTime;
    private String deptNumber;
    private String deptNumber1;

    public Integer status;




    @TableId("rest_id")
    private Integer restId;

    /**
     * 用户id
     */
    @TableField("u_id")
    private Long uId;

    /**
     * 调休开始时间
     */
    @TableField("start_time")
    private String  startTime;

    /**
     * 调休结束时间
     */
    @TableField("end_time")
    private String  endTime;

    /**
     * 总调休时长
     */
    @TableField("rest_time")
    private Double restTime;

    /**
     * 申请调休时间
     */
    @TableField("apply_rest_time")
    private Double applyRestTime;

    /**
     * 调休原因
     */
    private String reason;


    /**
     * 调休月份
     */
    private String month;

    @TableField("r_status")
    private Integer rStatus;

    private User user;


    public Integer getRestId() {
        return restId;
    }

    public void setRestId(Integer restId) {
        this.restId = restId;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Rest{" +
                "restId=" + restId +
                ", uId=" + uId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", restTime=" + restTime +
                ", applyRestTime=" + applyRestTime +
                ", reason='" + reason + '\'' +
                ", month='" + month + '\'' +
                ", rStatus=" + rStatus +
                ", user=" + user +
                '}';
    }
}