package com.zbzl.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zbzl.dao.SysMenuPowerMapper;
import com.zbzl.entity.SysMenuPower;
import com.zbzl.service.SysMenuPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuPowerServiceImpl implements SysMenuPowerService {

  @Autowired
  private SysMenuPowerMapper sysMenuPowerMapper;


  @Override
  public int deleteByPrimaryKey(String menuPowerId) {
    return sysMenuPowerMapper.deleteByPrimaryKey(menuPowerId);
  }

  @Override
  public int insert(SysMenuPower sysMenuPower) {
    return sysMenuPowerMapper.insert(sysMenuPower);
  }

  @Override
  public SysMenuPower selectByPrimaryKey(String menuPowerId) {
    return sysMenuPowerMapper.selectByPrimaryKey(menuPowerId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysMenuPower sysMenuPower) {
    return sysMenuPowerMapper.updateByPrimaryKeySelective(sysMenuPower);
  }


  @Override
  public List<SysMenuPower> getMenuPower(String roleId) {
    return sysMenuPowerMapper.getMenuPower(roleId);
  }
}
