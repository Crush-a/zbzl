package com.zbzl.service;


import com.zbzl.entity.SysMenuPower;

import java.util.List;

public interface SysMenuPowerService {

  //删除
  int deleteByPrimaryKey(String menuPowerId);
  //增加
  int insert(SysMenuPower sysMenuPower);
  //查询单条
  SysMenuPower selectByPrimaryKey(String menuPowerId);
  //修改
  int updateByPrimaryKeySelective(SysMenuPower record);
  //  通过权限Id查询到菜单
  List<SysMenuPower> getMenuPower(String powerId);


}
