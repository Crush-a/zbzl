package com.zbzl.controller;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRole;
import com.zbzl.entity.SysRoleUser;
import com.zbzl.service.SysRoleService;
import com.zbzl.service.SysRoleUserService;
import com.zbzl.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysRoleController {

@Autowired
  private SysRoleService sysRoleService;
@Autowired
private SysRoleUserService sysRoleUserService;
@Autowired
private SysUserService sysUserService;

  //  分页查询
  @RequestMapping(value = "/getRoleAll",method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getALL(PageQuery pageQuery) {
    String Temp = "";
    if("".equals(pageQuery.getName()) || pageQuery.getName() != null){
      Temp += " and role_name like '%"+pageQuery.getName()+"%'";
    }
    pageQuery.setExSql(Temp);
    List<SysRole> pageInfo = sysRoleService.selectByExample(pageQuery);
    int listSize = sysRoleService.selectCountByExample(pageQuery);
    Map<String, Object> map = new HashMap<String,Object>();
    if (listSize>=0){
      map.put("code", 0);
      map.put("msg", "查询成功");
      map.put("count", listSize);
      map.put("data", pageInfo);
    }else {
      map.put("code", 1);
      map.put("msg", "查询失败");

    }
    return map;
  }

  //  查询单条
  @RequestMapping(value = "/getRoleById",method = RequestMethod.GET)
  @ResponseBody
  public SysRole getById(String roleId){
    SysRole  sysRole= sysRoleService.selectByPrimaryKey(roleId);
    return sysRole ;
  }

  //  删除
  @RequestMapping(value = "/getRoleDelete",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> deletBy(String ids) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    PageQuery pageQuery = new PageQuery();
    String Temp = "";
    Temp = "("+ids+")";
    pageQuery.setExSql(Temp);
    //调用业务
    int temp=sysRoleService.deleteMoreDistrict(pageQuery);
    if (temp>0){
      map.put("code",0);
      map.put("msg","删除成功！");
    }else {
      map.put("code",1);
      map.put("msg","修改失败！");
    }
    return map;
  }

  //添加
  @RequestMapping(value = "/getRoleAdd",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getAdd(@RequestBody SysRole sysRole) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    String temp =  sysUserService.getDataByExmple("role_id","sys_role","role_name",sysRole.getRoleName());
    if(!"".equals(temp) || temp != null || !"null".equals(temp)){
      map.put("code", 1);
      map.put("msg", "角色名重复，请重新输入");
      return map;
    }
    int role = sysRoleService.getMaxId()+1;
    String role_id = role+"";
    sysRole.setRoleId(role_id);
    int insert = sysRoleService.insert(sysRole);
    //子表
    List<SysRoleUser> sysRoleUsers = sysRole.getSysRoleUsers();
    for (SysRoleUser sysRoleUser:sysRoleUsers){
      int roleUserMax = sysRoleUserService.getMaxId()+1;
      String role_user_id = roleUserMax+"";
      sysRoleUser.setRoleUserId(role_user_id);
      sysRoleUser.setRoleId(sysRole.getRoleId());
      int i = sysRoleUserService.insert(sysRoleUser);
    }
    if(insert > 0){
      map.put("code", 0);
      map.put("msg", "添加成功");
    }else{
      map.put("code", 1);
      map.put("msg", "添加失败");
    }
    return map;
  }

  //  修改
  @RequestMapping(value = "/getRoleUpdate",method = RequestMethod.POST)
  @ResponseBody
  public Map<Object, Object> getSysDictUpdate(@RequestBody SysRole sysRole){
    Map<Object,Object> map =new HashMap<Object,Object>();
    String roleId = sysRole.getRoleId();
    //子表
    int i1 = sysRoleUserService.deleteByRoleId(sysRole.getRoleId());
    List<SysRoleUser> list = sysRole.getSysRoleUsers();
    if (list !=null && list.size()>0){
      for (SysRoleUser sysRoleUser:list){
        int itemMax = sysRoleUserService.getMaxId()+1;
        String role_user_id = itemMax+"";
        sysRoleUser.setRoleUserId(role_user_id);
        sysRoleUser.setRoleId(sysRole.getRoleId());
        int i = sysRoleUserService.insert(sysRoleUser);
    if( i> 0){
      map.put("code", 0);
      map.put("msg", "修改成功");
     }else{
      map.put("code", 1);
      map.put("msg", "修改失败");
    }
      }
  }
    return map;
  }
}






