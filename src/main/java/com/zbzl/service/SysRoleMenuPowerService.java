package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRoleMenuPower;

import java.util.List;

public interface SysRoleMenuPowerService {

  //删除
  int deleteByPrimaryKey(String roleMenuPowerId);
  //增加
  int insert(SysRoleMenuPower sysRoleMenuPower);
  //查询单条
  List<SysRoleMenuPower> selectByPrimaryKey(String role_id);
  //修改
  int updateByPrimaryKey(SysRoleMenuPower sysRoleMenuPower);
  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

  int getMaxId();

  List<SysRoleMenuPower> selectId(String role_id);
  //连表查询
  List<SysRoleMenuPower> getByBrowser(String roleId);

  int deleteByRoleId(String roleId);
 }
