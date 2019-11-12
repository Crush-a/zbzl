package com.zbzl.service.Impl;

import com.zbzl.dao.SysUserMenuPowerMapper;
import com.zbzl.entity.SysUserMenuPower;
import com.zbzl.service.SysUserMenuPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserMenuPowerServiceImpl implements SysUserMenuPowerService {
  @Autowired
  private SysUserMenuPowerMapper sysUserMenuPowerMapper;



  @Override
  public List<SysUserMenuPower> getByBrowser(String roleId) {
    return sysUserMenuPowerMapper.getByBrowser(roleId);
  }
}
