package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRoleMenuPower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMenuPowerMapper {
    int deleteByPrimaryKey(String roleMenuPowerId);

    int insert(SysRoleMenuPower record);

    int insertSelective(SysRoleMenuPower record);

    List<SysRoleMenuPower> selectByPrimaryKey(String role_id);

    int updateByPrimaryKeySelective(SysRoleMenuPower record);

    int updateByPrimaryKey(SysRoleMenuPower record);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    int getMaxId();

    List<SysRoleMenuPower> selectId(String role_id);
    //连表查询
    List<SysRoleMenuPower> getByBrowser(String roleId);

    int deleteByRoleId(String roleId);
}