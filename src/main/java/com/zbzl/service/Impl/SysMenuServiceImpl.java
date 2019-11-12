package com.zbzl.service.Impl;


import com.zbzl.dao.SysMenuMapper;
import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysMenu;
import com.zbzl.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {


  @Autowired
  private SysMenuMapper sysMenuMapper;




  @Override
  public int insert(SysMenu sysMenu) {
    return sysMenuMapper.insert(sysMenu);
  }

  @Override
  public List<SysMenu> selectAll() {
    return sysMenuMapper.selectAll();
  }


  @Override
  public int deleteMoreDistrict(PageQuery pageQuery) {
    return sysMenuMapper.deleteMoreDistrict(pageQuery);
  }

  @Override
  public SysMenu selectByPrimaryKey(String menuId) {
    return sysMenuMapper.selectByPrimaryKey(menuId);
  }

  @Override
  public int updateByPrimaryKeySelective(SysMenu sysMenu) {
    return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
  }

  @Override
  public List<SysMenu> selectByExample(PageQuery pageQuery) {
    return sysMenuMapper.selectByExample(pageQuery);
  }

  @Override
  public int selectCountByExample(PageQuery pageQuery) {
    return sysMenuMapper.selectCountByExample(pageQuery);
  }

  @Override
  public int getMaxId() {
    return sysMenuMapper.getMaxId();
  }

  @Override
  public List<SysMenu> selectByMenuName(String menuName) {
    return sysMenuMapper.selectByMenuName(menuName);
  }


  @Override
  public int deleteByPrimaryKey(String userId) {
    return sysMenuMapper.deleteByPrimaryKey(userId);
  }


}
