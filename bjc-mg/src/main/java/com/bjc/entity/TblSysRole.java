package com.bjc.entity;

import java.io.Serializable;

/**
 * tbl_sys_role
 * @author 
 */
public class TblSysRole implements Serializable {
    /**
     * 主键
     */
    private Integer roleId;

    /**
     * 角色名
     */
    private String rName;

    /**
     * 角色等级
     */
    private String rGrade;

    /**
     * 是否传递
     */
    private Integer rTransferable;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrGrade() {
        return rGrade;
    }

    public void setrGrade(String rGrade) {
        this.rGrade = rGrade;
    }

    public Integer getrTransferable() {
        return rTransferable;
    }

    public void setrTransferable(Integer rTransferable) {
        this.rTransferable = rTransferable;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TblSysRole other = (TblSysRole) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getrName() == null ? other.getrName() == null : this.getrName().equals(other.getrName()))
            && (this.getrGrade() == null ? other.getrGrade() == null : this.getrGrade().equals(other.getrGrade()))
            && (this.getrTransferable() == null ? other.getrTransferable() == null : this.getrTransferable().equals(other.getrTransferable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getrName() == null) ? 0 : getrName().hashCode());
        result = prime * result + ((getrGrade() == null) ? 0 : getrGrade().hashCode());
        result = prime * result + ((getrTransferable() == null) ? 0 : getrTransferable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", rName=").append(rName);
        sb.append(", rGrade=").append(rGrade);
        sb.append(", rTransferable=").append(rTransferable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}