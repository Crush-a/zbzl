package com.zbzl.service.Impl;


import com.zbzl.dao.SysRoleMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRole;
import com.zbzl.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

  @Autowired
  private SysRoleMapper sysRoleMapper;

  @Override
  public int deleteByPrimaryKey(String roleId) {
    return sysRoleMapper.deleteByPrimaryKey(roleId);
  }

  @Override
  public int insert(SysRole sysRole) {
    return sysRoleMapper.insert(sysRole);
  }


  @Override
  public SysRole selectByPrimaryKey(String roleId) {
    return sysRoleMapper.selectByPrimaryKey(roleId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysRole sysRole) {
    return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
  }

  @Override
  public List<SysRole> selectByExample(PageQuery pageQuery) {
    return sysRoleMapper.selectByExample(pageQuery);
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysRoleMapper.selectCountByExample(pageQuery);
  }

  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysRoleMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysRoleMapper.getMaxId();
  }


}
