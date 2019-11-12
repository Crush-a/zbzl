package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysUser;

import java.util.List;

public interface SysUserService {

  //删除
  int deleteByPrimaryKey(String userId);

  //  增加
  int insertSelective(SysUser record);

  //查询单条
  SysUser selectByPrimaryKey(String userId);

  //修改
  int updateByPrimaryKeySelective(SysUser sysUser);

  //  分页
  List<SysUser> selectByExample(PageQuery pageQuery);
  //获取总条数
  int selectCountByExample(PageQuery pageQuery);

  //  登录
  SysUser login(SysUser sysUser);

  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

//修改密码
  int updateByUserPass(String userId, String newPass);

  int getMaxId();
//查重
  String getDataByExmple(String outCol, String tableName, String inCol, String inData);

}