package com.zbzl.service.Impl;


import com.zbzl.dao.SysDictItemMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDictItem;
import com.zbzl.service.SysDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysDictItemServiceImpl implements SysDictItemService {

  @Autowired

  private SysDictItemMapper sysDictItemMapper;


  @Override
  public int deleteByPrimaryKey(String itemId) {
    return sysDictItemMapper.deleteByPrimaryKey(itemId);
  }

  @Override
  public int insert(SysDictItem sysDictItem) {
    return sysDictItemMapper.insert(sysDictItem);
  }

  @Override
  public SysDictItem selectByPrimaryKey(String itemId) {
    return sysDictItemMapper.selectByPrimaryKey(itemId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysDictItem sysDictItem) {
    return sysDictItemMapper.updateByPrimaryKeySelective(sysDictItem);
  }

  @Override
  public List<SysDictItem> selectByExample(PageQuery pageQuery) {
    return sysDictItemMapper.selectByExample(pageQuery);
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysDictItemMapper.selectCountByExample(pageQuery);
  }

  @Override
  public int deleteByDictId(String dictId) {
    return sysDictItemMapper.deleteByDictId(dictId);
  }

  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysDictItemMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysDictItemMapper.getMaxId();
  }

  @Override
  public List<SysDictItem> selectByDictId(String dictId) {
    return sysDictItemMapper.selectByDictId(dictId);
  }


  @Override
  public List<SysDictItem> getDictItemById(String itemId) {
    return sysDictItemMapper.getDictItemById(itemId);
  }

  @Override
  public List<SysDictItem> getByName(String dictId) {
    return sysDictItemMapper.getByName(dictId);
  }


}