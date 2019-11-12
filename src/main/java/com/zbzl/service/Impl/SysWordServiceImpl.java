package com.zbzl.service.Impl;

import com.zbzl.dao.SysWordMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysWord;
import com.zbzl.service.SysWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysWordServiceImpl implements SysWordService {
@Autowired(required = false)
private SysWordMapper sysWordMapper;
  @Override
  public int deleteByPrimaryKey(String wordId) {
    return sysWordMapper.deleteByPrimaryKey(wordId);
  }

  @Override
  public int insert(SysWord sysWord) {
    return sysWordMapper.insert(sysWord);
  }

  @Override
  public SysWord selectByPrimaryKey(String wordId) {
    return sysWordMapper.selectByPrimaryKey(wordId);
  }

  @Override
  public int updateByPrimaryKey(SysWord sysWord) {
    return sysWordMapper.updateByPrimaryKey(sysWord);
  }

  @Override
  public List<SysWord> selectByExample(PageQuery pageQuery) {
    return sysWordMapper.selectByExample(pageQuery);
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysWordMapper.selectCountByExample(pageQuery);
  }

  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysWordMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysWordMapper.getMaxId();
  }

  @Override
  public List<SysWord> selectMh(PageQuery pageQuery) {
    return sysWordMapper.selectMh(pageQuery);
  }


}
