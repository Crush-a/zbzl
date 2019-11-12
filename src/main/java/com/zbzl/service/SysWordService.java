package com.zbzl.service;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysWord;

import java.util.List;

public interface SysWordService {

  int deleteByPrimaryKey(String wordId);

  int insert(SysWord record);

  SysWord selectByPrimaryKey(String wordId);

  int updateByPrimaryKey(SysWord record);
  //  分页
  List<SysWord> selectByExample(PageQuery pageQuery);

  int selectCountByExample(PageQuery pageQuery);
  //批量删除
  int deleteMoreDistrict(PageQuery pageQuery);

  int getMaxId();

  List<SysWord> selectMh(PageQuery pageQuery);


}
