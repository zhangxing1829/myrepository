package com.bjc.entity;

import java.io.Serializable;

/**
 * tbl_sys_permission
 * @author 
 */
public class TblSysPermission implements Serializable {
    private Integer pId;

    /**
     * 权限名
     */
    private String pName;

    /**
     * 权限链接
     */
    private String pUrl;

    /**
     * 权限描述
     */
    private String pDescription;

    /**
     * 菜单等级
     */
    private Integer pGrade;

    private static final long serialVersionUID = 1L;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public Integer getpGrade() {
        return pGrade;
    }

    public void setpGrade(Integer pGrade) {
        this.pGrade = pGrade;
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
        TblSysPermission other = (TblSysPermission) that;
        return (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getpName() == null ? other.getpName() == null : this.getpName().equals(other.getpName()))
            && (this.getpUrl() == null ? other.getpUrl() == null : this.getpUrl().equals(other.getpUrl()))
            && (this.getpDescription() == null ? other.getpDescription() == null : this.getpDescription().equals(other.getpDescription()))
            && (this.getpGrade() == null ? other.getpGrade() == null : this.getpGrade().equals(other.getpGrade()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getpName() == null) ? 0 : getpName().hashCode());
        result = prime * result + ((getpUrl() == null) ? 0 : getpUrl().hashCode());
        result = prime * result + ((getpDescription() == null) ? 0 : getpDescription().hashCode());
        result = prime * result + ((getpGrade() == null) ? 0 : getpGrade().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", pName=").append(pName);
        sb.append(", pUrl=").append(pUrl);
        sb.append(", pDescription=").append(pDescription);
        sb.append(", pGrade=").append(pGrade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}