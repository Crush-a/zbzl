package com.zbzl.service;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDictItem;

import java.util.List;

public interface SysDictItemService {

  //删除
  int deleteByPrimaryKey(String itemId);
  //增加
  int insert(SysDictItem record);

  //查询单条
  SysDictItem selectByPrimaryKey(String itemId);
  //修改
  int updateByPrimaryKeySelective(SysDictItem record);
  //  分页
  List<SysDictItem> selectByExample(PageQuery pageQuery);

  int selectCountByExample(PageQuery pageQuery);

  int  deleteByDictId(String dictId);
  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

  int getMaxId();
  //通过字典id查询
  List<SysDictItem> selectByDictId(String dictId);
  //通过字典项Id查询字典项
  List<SysDictItem>  getDictItemById(String itemId);
  //通过字典表Id查询
  List<SysDictItem> getByName(String dictId);
}
