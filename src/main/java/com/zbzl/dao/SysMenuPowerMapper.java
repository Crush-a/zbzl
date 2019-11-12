package com.zbzl.dao;

import com.zbzl.entity.SysMenuPower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysMenuPowerMapper {
    int deleteByPrimaryKey(String menuPowerId);

    int insert(SysMenuPower record);

    int insertSelective(SysMenuPower record);

    SysMenuPower selectByPrimaryKey(String menuPowerId);

    int updateByPrimaryKeySelective(SysMenuPower record);

    int updateByPrimaryKey(SysMenuPower record);
    //通过权限Id查到数据
    List<SysMenuPower> getMenuPower(String powerId);
}