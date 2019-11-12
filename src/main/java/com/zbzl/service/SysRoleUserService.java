package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRoleUser;

import java.util.List;

public interface SysRoleUserService {
  //删除
  int deleteByPrimaryKey(String roleUserId);
  //增加
  int insert(SysRoleUser record);
  //查询单条
  SysRoleUser selectByPrimaryKey(String roleUserId);
  //修改
  int updateByPrimaryKeySelective(SysRoleUser record);
  //  分页
  List<SysRoleUser> selectByExample(PageQuery pageQuery);

  int selectCountByExample(PageQuery pageQuery);

  int  deleteByRoleId(String roleId);

  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

  int getMaxId();

  //通过用户Id查角色
  List<SysRoleUser> getUserId(String userId);

  List<SysRoleUser> selectByRoleId (String roleId);
}
