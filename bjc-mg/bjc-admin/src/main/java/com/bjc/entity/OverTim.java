package com.bjc.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * tbl_bs_rest
 * @author 
 */
@Data
@TableName("tbl_bs_overtim")
public class OverTim implements Serializable {

    private String number;
    private  String name;
    private String applyTime;
    private String deptNumber;
    private String deptNumber1;

    public Integer status;



    @TableId("overtime_id")
    private Integer overtimeId;

    /**
     * 用户id
     */
    @TableField("u_id")
    private Long uId;

    /**
     * 加班开始时间
     */
    @TableField("start_time")
    private String startTime;

    /**
     * 加班结束时间
     */
    @TableField("end_time")
    private String endTime;

    /**
     * 加班时长
     */
    @TableField("over_time")
    private String  overTime;


    /**
     * 加班原因
     */
    private String reason;



    /**
     * 加班月份
     */
    private String month;

    private User user;


    private static final long serialVersionUID = 1L;

}