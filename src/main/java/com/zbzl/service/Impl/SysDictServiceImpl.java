package com.zbzl.service.Impl;

import com.zbzl.dao.SysDictMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDict;
import com.zbzl.entity.SysDictItem;
import com.zbzl.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

  @Autowired
private SysDictMapper sysDictMapper;


  @Override
  public int deleteByPrimaryKey(String dictId) {
    return sysDictMapper.deleteByPrimaryKey(dictId);
  }

  @Override
  public int insertSelective(SysDict sysDict) {
    return sysDictMapper.insertSelective(sysDict);
  }


  @Override
  public SysDict selectByPrimaryKey(String dictId) {
    return sysDictMapper.selectByPrimaryKey(dictId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysDict sysDict) {
    return sysDictMapper.updateByPrimaryKeySelective(sysDict);
  }



  @Override
  public List<SysDict> selectByExample(PageQuery pageQuery) {
    return sysDictMapper.selectByExample(pageQuery);
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysDictMapper.selectCountByExample(pageQuery);
  }

  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysDictMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysDictMapper.getMaxId();
  }

  @Override
  public List<SysDict> getDictName(String dictTs) {
    return sysDictMapper.getDictName(dictTs);
  }

  @Override
  public List<SysDict> getDictById(String dictId) {
    return sysDictMapper.getDictById(dictId);
  }


}
