package com.zbzl.service;

import com.zbzl.entity.SysUserMenuPower;

import java.util.List;

public interface SysUserMenuPowerService {

  List<SysUserMenuPower> getByBrowser(String roleId);
}
