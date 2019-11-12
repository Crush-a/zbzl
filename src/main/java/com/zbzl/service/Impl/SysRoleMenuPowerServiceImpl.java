package com.zbzl.service.Impl;


import com.zbzl.dao.SysRoleMenuPowerMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRoleMenuPower;
import com.zbzl.service.SysRoleMenuPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMenuPowerServiceImpl implements SysRoleMenuPowerService {

  @Autowired
  private SysRoleMenuPowerMapper sysRoleMenuPowerMapper;

  @Override
  public int deleteByPrimaryKey(String roleMenuPowerId) {
    return sysRoleMenuPowerMapper.deleteByPrimaryKey(roleMenuPowerId);
  }

  @Override
  public int insert(SysRoleMenuPower sysRoleMenuPower) {
    return sysRoleMenuPowerMapper.insert(sysRoleMenuPower);
  }

  @Override
  public List<SysRoleMenuPower> selectByPrimaryKey(String role_id) {
    return sysRoleMenuPowerMapper.selectByPrimaryKey(role_id);
  }

  @Override
  public int updateByPrimaryKey(SysRoleMenuPower sysRoleMenuPower) {
    return sysRoleMenuPowerMapper.updateByPrimaryKey(sysRoleMenuPower);
  }


  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysRoleMenuPowerMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysRoleMenuPowerMapper.getMaxId();
  }

  @Override
  public List<SysRoleMenuPower> selectId(String role_id) {
    return sysRoleMenuPowerMapper.selectId(role_id);
  }

  @Override
  public List<SysRoleMenuPower> getByBrowser( String roleId) {
    return sysRoleMenuPowerMapper.getByBrowser(roleId);
  }

  @Override
  public int deleteByRoleId(String roleId) {
    return sysRoleMenuPowerMapper.deleteByRoleId(roleId);
  }


}