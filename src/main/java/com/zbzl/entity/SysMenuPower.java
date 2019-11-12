package com.zbzl.entity;

public class SysMenuPower {
    private String menuPowerId;

    private String menuId;

    private String powerId;

    private String menuName;

    private String menuCode;

    private String powerName;

    private String powerCode;

    private String menuPowerValid;

    public String getMenuPowerId() {
        return menuPowerId;
    }

    public void setMenuPowerId(String menuPowerId) {
        this.menuPowerId = menuPowerId == null ? null : menuPowerId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId == null ? null : powerId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
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

    public String getMenuPowerValid() {
        return menuPowerValid;
    }

    public void setMenuPowerValid(String menuPowerValid) {
        this.menuPowerValid = menuPowerValid == null ? null : menuPowerValid.trim();
    }
}