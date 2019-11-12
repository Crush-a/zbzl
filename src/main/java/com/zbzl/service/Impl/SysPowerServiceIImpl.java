package com.zbzl.service.Impl;


import com.zbzl.dao.SysPowerMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysPower;
import com.zbzl.service.SysPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPowerServiceIImpl implements SysPowerService {
  @Autowired
  private SysPowerMapper sysPowerMapper;

  @Override
  public int deleteByPrimaryKey(String powerId) {
    return sysPowerMapper.deleteByPrimaryKey(powerId);
  }

  @Override
  public int insert(SysPower sysPower) {
    return sysPowerMapper.insert(sysPower);
  }

  @Override
  public SysPower selectByPrimaryKey(String powerId) {
    return sysPowerMapper.selectByPrimaryKey(powerId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysPower sysPower) {
    return sysPowerMapper.updateByPrimaryKeySelective(sysPower);
  }


  @Override
  public List<SysPower> selectByExample(PageQuery pageQuery) {
    return sysPowerMapper.selectByExample(pageQuery);
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysPowerMapper.selectCountByExample(pageQuery);
  }

  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysPowerMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysPowerMapper.getMaxId();
  }

  @Override
  public List<SysPower> selectAll() {
    return sysPowerMapper.selectAll();
  }


}
