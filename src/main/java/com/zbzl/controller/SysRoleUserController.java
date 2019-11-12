package com.zbzl.controller;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRole;
import com.zbzl.entity.SysRoleUser;
import com.zbzl.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysRoleUserController {
  @Autowired
  private SysRoleUserService sysRoleUserService;

  //  分页查询
  @RequestMapping(value = "/getRoleUserAll", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getALL(String roleId) {
    List<SysRoleUser> sysRoleUsers = sysRoleUserService.selectByRoleId(roleId);
   Map<Object, Object> map = new HashMap<Object,Object>();
    if (sysRoleUsers != null) {
      map.put("code", 0);
      map.put("msg", "查询成功！");
      map.put("data", sysRoleUsers);
    } else {
      map.put("code", 0);
      map.put("msg", "查询失败！");

    }
    return map;
  }

  //  查询单条
  @RequestMapping(value = "/getRoleUserById", method = RequestMethod.GET)
  @ResponseBody
  public SysRoleUser getById(String roleUserId) {
    SysRoleUser sysRoleUser = sysRoleUserService.selectByPrimaryKey(roleUserId);
    return sysRoleUser;
  }

  //  删除
  @RequestMapping(value = "/getRoleUserDelete", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> deletBy(String ids) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    PageQuery pageQuery = new PageQuery();
    String Temp = "";
    Temp = "(" + ids + ")";
    pageQuery.setExSql(Temp);
    //调用业务
    int temp = sysRoleUserService.deleteMoreDistrict(pageQuery);
    if (temp > 0) {
      map.put("code", 0);
      map.put("msg", "删除成功！");
    } else {
      map.put("code", 1);
      map.put("msg", "修改失败！");
    }
    return map;
  }

  //添加
  @RequestMapping(value = "/getRoleUserAdd", method = RequestMethod.POST, consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getAdd(SysRoleUser sysRoleUser) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    int max = sysRoleUserService.getMaxId() + 1;
    String role_user_id = max + "";
    sysRoleUser.setRoleUserId(role_user_id);
    int insert = sysRoleUserService.insert(sysRoleUser);
    if (insert > 0) {
      map.put("code", 0);
      map.put("msg", "添加成功");
    } else {
      map.put("code", 1);
      map.put("msg", "添加失败");
    }
    return map;
  }

  //  修改
  @RequestMapping(value = "/getRoleUserUpdate", method = RequestMethod.POST, consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getUpdate(SysRoleUser sysRoleUser, SysRole sysRole) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    String roleId = sysRole.getRoleId();
    int i2 = sysRoleUserService.deleteByRoleId(roleId);
    int insert = sysRoleUserService.insert(sysRoleUser);
    if (insert > 0) {
      map.put("code", 0);
      map.put("msg", "修改成功");
    } else {
      map.put("code", 1);
      map.put("msg", "修改失败");
    }
    return map;
  }
}