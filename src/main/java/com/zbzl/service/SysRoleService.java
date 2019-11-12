package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRole;

import java.util.List;

public interface SysRoleService {
//删除
  int deleteByPrimaryKey(String roleId);
//增加
  int insert(SysRole record);
//查询单条
  SysRole selectByPrimaryKey(String roleId);
//修改
  int updateByPrimaryKeySelective(SysRole record);
  //  分页
  List<SysRole> selectByExample(PageQuery pageQuery);

  int selectCountByExample(PageQuery pageQuery);
  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

  int getMaxId();
}
