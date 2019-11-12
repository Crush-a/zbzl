package com.zbzl.entity;

public class SysPower {
    private String powerId;

    private String powerName;

    private String powerCode;

    private String powerValid;

    private String remark;

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId == null ? null : powerId.trim();
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName == null ? null : powerName.trim();
    }

    public String getPowerCode() {
        return powerCode;
    }

    public void setPowerCode(String powerCode) {
        this.powerCode = powerCode == null ? null : powerCode.trim();
    }

    public String getPowerValid() {
        return powerValid;
    }

    public void setPowerValid(String powerValid) {
        this.powerValid = powerValid == null ? null : powerValid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}