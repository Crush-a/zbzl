package com.zbzl.service.Impl;


import com.zbzl.dao.SysUserMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysUser;
import com.zbzl.service.SysUserService;
import com.zbzl.until.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
  @Autowired
  private SysUserMapper sysUserMapper;

  @Override
  public List<SysUser> selectByExample(PageQuery pageQuery) {
    List<SysUser> sysUsers = sysUserMapper.selectByExample(pageQuery);
    return sysUsers;
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysUserMapper.selectCountByExample(pageQuery);
  }

  @Override
  public SysUser login(SysUser sysUser) {
    SysUser sysUser1  = sysUserMapper.login(sysUser);
    return sysUser1;
  }

  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysUserMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public int updateByUserPass(String userId, String newPass) {
    Map<String,Object> map=new HashMap<String,Object>();
    if (userId!=null){
        SysUser sysUser1=new SysUser();
        sysUser1.setUserId(userId);
        sysUser1.setUserPass(MD5Utils.md5Encrypt(newPass));
        return sysUserMapper.updateByPrimaryKeySelective(sysUser1);
    }
    return 0;
  }

  @Override
  public int getMaxId() {
    return sysUserMapper.getMaxId();
  }

  @Override
  public String getDataByExmple(String outCol, String tableName, String inCol, String inData) {
    return sysUserMapper.getDataByExmple(outCol,tableName,inCol,inData);
  }


  @Override
  public int deleteByPrimaryKey(String userId) {
    return sysUserMapper.deleteByPrimaryKey(userId);
  }

  @Override
  public int insertSelective(SysUser sysUser) {
    return sysUserMapper.insertSelective(sysUser);
  }


  @Override
  public SysUser selectByPrimaryKey(String userId) {
    return sysUserMapper.selectByPrimaryKey(userId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysUser sysUser) {
    return sysUserMapper.updateByPrimaryKeySelective(sysUser);
  }




}