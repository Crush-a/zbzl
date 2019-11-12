package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysMenu;

import java.util.List;

public interface SysMenuService {
  //删除
  int deleteByPrimaryKey(String menuId);
  //增加
  int insert(SysMenu record);
  //查询所有；不分页
  List<SysMenu>  selectAll ();
  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);
  //查询单条
  SysMenu selectByPrimaryKey(String menuId);
  //修改
  int updateByPrimaryKeySelective(SysMenu record);
  //  分页
  List<SysMenu> selectByExample(PageQuery pageQuery);
  //获取总条数
  int selectCountByExample(PageQuery pageQuery);
  //获取最大值
  int getMaxId();

  List<SysMenu> selectByMenuName(String menuName);




}
