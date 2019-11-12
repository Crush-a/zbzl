package com.zbzl.service.Impl;


import com.zbzl.dao.SysRoleUserMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRoleUser;
import com.zbzl.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

@Autowired
  private SysRoleUserMapper sysRoleUserMapper;


  @Override
  public int deleteByPrimaryKey(String roleUserId) {
    return sysRoleUserMapper.deleteByPrimaryKey(roleUserId);
  }

  @Override
  public int insert(SysRoleUser sysRoleUser) {
    return sysRoleUserMapper.insert(sysRoleUser);
  }

  @Override
  public SysRoleUser selectByPrimaryKey(String roleUserId) {
    return sysRoleUserMapper.selectByPrimaryKey(roleUserId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysRoleUser sysRoleUser) {
    return sysRoleUserMapper.updateByPrimaryKeySelective(sysRoleUser);
  }

  @Override
  public List<SysRoleUser> selectByExample(PageQuery pageQuery) {
    return sysRoleUserMapper.selectByExample(pageQuery);
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysRoleUserMapper.selectCountByExample(pageQuery);
  }

  @Override
  public int deleteByRoleId(String roleId) {
    return sysRoleUserMapper.deleteByRoleId(roleId);
  }

  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysRoleUserMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysRoleUserMapper.getMaxId();
  }

  @Override
  public List<SysRoleUser> getUserId(String userId) {
    return sysRoleUserMapper.getUserId(userId);
  }

  @Override
  public List<SysRoleUser> selectByRoleId(String roleId) {
    return sysRoleUserMapper.selectByRoleId(roleId);
  }


}
