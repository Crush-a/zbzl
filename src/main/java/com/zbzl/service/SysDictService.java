package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDict;

import java.util.List;

public interface SysDictService {

  //删除
  int deleteByPrimaryKey(String dictId);
  //增加
  int insertSelective(SysDict record);

  //查询单条
  SysDict selectByPrimaryKey(String dictId);
  //修改
  int updateByPrimaryKeySelective(SysDict record);
  //  分页
  List<SysDict> selectByExample(PageQuery pageQuery);

  int selectCountByExample(PageQuery pageQuery);
  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

  int getMaxId();
  //通过特殊符号查询
  List<SysDict> getDictName(String dictTs);
  //通过字典表Id查询字典表
  List<SysDict>  getDictById(String dictId);
}
