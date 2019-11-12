package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysPower;

import java.util.List;

public interface SysPowerService {

  //删除
  int deleteByPrimaryKey(String powerId);
  //增加
  int insert(SysPower record);
  //查询单条
  SysPower selectByPrimaryKey(String powerId);
  //修改
  int updateByPrimaryKeySelective(SysPower record);
  //  分页
  List<SysPower> selectByExample(PageQuery pageQuery);
  //获取总条数
  int selectCountByExample(PageQuery pageQuery);
  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

  int getMaxId();

  List<SysPower>  selectAll ();




}
