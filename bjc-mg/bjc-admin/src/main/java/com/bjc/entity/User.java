package com.bjc.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import groovy.transform.Field;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * tbl_sys_user
 * @author
 */
@Data
@TableName("tbl_sys_user")
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId("u_id")
    private long uId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 主管工号
     */
    @TableField("manager_number")
    private String managerNumber;

    /**
     * 性别
     */
    private String sex;

    /**
     * 工号
     */
    private String number;

    /**
     * 华为工号
     */
    @TableField("hw_number")
    private String hwNumber;

    /**
     * 部门编号
     */
    @TableField("dept_number")
    private String deptNumber;


    /**
     * 部门编号
     */
    @TableField(exist = false)
    private String deptNumber1;




    /**
     * 联系方式
     */
    private String phone;

    /**
     * 微信号
     */
    private String weixin;

    /**
     * 盐
     */
    private String salt;

    /**
     * 0、禁用 1、正常
     */
    private Integer status;

    @TableField(exist = false)
    private String startTime;//搜索起始时间

    @TableField(exist = false)
   private String endTime;//搜索截止时间


    private static final long serialVersionUID = 1L;

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }


}