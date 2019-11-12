package com.zbzl.dao;

import com.zbzl.entity.SysUserMenuPower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUserMenuPowerMapper {

  List<SysUserMenuPower> getByBrowser(String roleId);
}
