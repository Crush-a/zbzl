package com.zbzl.entity;

public class SysUserMenuPower extends SysRoleMenuPower {

  @Override
  public String getMenuId() {
    return menuId;
  }

  @Override
  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  @Override
  public String getMenuCode() {
    return menuCode;
  }

  @Override
  public void setMenuCode(String menuCode) {
    this.menuCode = menuCode;
  }

  @Override
  public String getMenuName() {
    return menuName;
  }

  @Override
  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getMenuValid() {
    return menuValid;
  }

  public void setMenuValid(String menuValid) {
    this.menuValid = menuValid;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  private String menuId;

  private String menuCode;

  private String menuName;

  private String menuValid;

  private String remark;

  private String icon;

  private String href;

  private String pid;
}
