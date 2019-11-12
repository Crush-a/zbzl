package com.zbzl.controller;

import com.zbzl.entity.*;
import com.zbzl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysRoleMenuPowerController {

@Autowired
  private SysRoleMenuPowerService sysRoleMenuPowerService;
@Autowired
private SysPowerService sysPowerService;
@Autowired
private SysMenuService sysMenuService;
@Autowired
private SysUserMenuPowerService sysUserMenuPowerService;
@Autowired
private SysRoleUserService sysRoleUserService;

  //  查询单条
  @RequestMapping(value = "/getRoleMenuPowerById",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> getById(String role_id){
    List<SysRoleMenuPower> list = new ArrayList<SysRoleMenuPower>();
    if (!"".equals(role_id) && role_id != null){
       list = sysRoleMenuPowerService.selectId(role_id);
    }
    List<SysPower> sysPowers = sysPowerService.selectAll();
    List<SysMenu> sysMenus = sysMenuService.selectAll();
    List<SysMenu> menuList = new ArrayList<SysMenu>();
    List<SysMenu> childMenuList = new ArrayList<SysMenu>();
    //循环遍历所有菜单集合，将主菜单和子菜单分别存放入menuList和childMenuList中
    for(SysMenu sysMenu:sysMenus){
      if("-1".equals(sysMenu.getPid())){
        menuList.add(sysMenu);
      }else{
        childMenuList.add(sysMenu);
      }
    }
    List<SysMenu> allMenuList = new ArrayList<SysMenu>();
    //循环遍历主菜单和子菜单，将子菜单pid等于主菜单id的数据放入childList
    for(SysMenu sysMenu:menuList){
      List<SysMenu> childList = new ArrayList<SysMenu>();
      for(SysMenu sysChildMenu:childMenuList){
        //判断主菜单id跟子菜单的pid是否相等，如果相等，说明这个子菜单为主菜单的子，
        //然后就将子子菜单存入一个主菜单下的childList中
        if(sysMenu.getMenuId().equals(sysChildMenu.getPid())){
          childList.add(sysChildMenu);
        }
      }
      //将子菜单的集合放入主菜单的sysMenu属性中
      sysMenu.setChildren(childList);
      //将所有主菜单放入allMenuList中返回
      allMenuList.add(sysMenu);
    }
    Map<Object,Object> map =new HashMap<Object,Object>();
    if( sysPowers!= null&&sysMenus!=null){
      map.put("code", 0);
      map.put("msg", "查询成功");
      map.put("menuList",allMenuList);
      map.put("powerList",sysPowers);
      map.put("roleMenuPowerList",list);
    }else{
      map.put("code", 1);
      map.put("msg", "查询失败");
    }
    return map;
  }

  //  删除
  @RequestMapping(value = "/getRoleMenuPowerDelete",method = RequestMethod.GET)
  @ResponseBody
public Map<Object, Object> getRoleMenuPowerDelete(String ids) {
 Map<Object, Object> map = new HashMap<Object,Object>();
  PageQuery pageQuery = new PageQuery();
  String Temp = "";
  Temp = "("+ids+")";
  pageQuery.setExSql(Temp);
  //调用业务
  int temp=sysRoleMenuPowerService.deleteMoreDistrict(pageQuery);
  if (temp>0){
    map.put("code",0);
    map.put("msg","删除成功！");
  }else {
    map.put("code", 1);
    map.put("msg", "修改失败！");
  }
  return map;
}

  //添加
  @RequestMapping(value = "/getRoleMenuPowerAdd",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
  public Map<String,String> insert(@RequestBody List<SysRoleMenuPower> sysRoleMenuPowerList){
    Map<String,String> map = new HashMap<String,String>();
    int count = 0;
   if (sysRoleMenuPowerList==null){
     map.put("code", "1");
     map.put("msg", "添加失败，数据不能为空");
   }else {
     int delete = sysRoleMenuPowerService.deleteByRoleId(sysRoleMenuPowerList.get(0).getRoleId());
     for(SysRoleMenuPower sysRoleMenuPower:sysRoleMenuPowerList){
       int dictMax = sysRoleMenuPowerService.getMaxId()+1;
      String role_menu_power_id = dictMax+"";
      sysRoleMenuPower.setRoleMenuPowerId(role_menu_power_id);
      int insert = sysRoleMenuPowerService.insert(sysRoleMenuPower);
      count += insert;
    }}
    if(count > 0){
      map.put("code", "0");
      map.put("msg", "添加成功");
    }else{
      map.put("code", "1");
      map.put("msg", "添加失败");
    }
    return map;
  }

  // 修改
  @RequestMapping(value = "/getRoleMenuPowerUpdate",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getUpdate(@RequestBody List<SysRoleMenuPower> sysRoleMenuPowerList,String roleMenuPowerId) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    int i1 = sysRoleMenuPowerService.deleteByPrimaryKey(roleMenuPowerId);
    for (SysRoleMenuPower sysRoleMenuPower : sysRoleMenuPowerList) {
      int dictMax = sysRoleMenuPowerService.getMaxId() + 1;
      String role_menu_power_id = dictMax + "";
      sysRoleMenuPower.setRoleMenuPowerId(role_menu_power_id);
      int insert = sysRoleMenuPowerService.insert(sysRoleMenuPower);
      if (insert > 0) {
        map.put("code", 0);
        map.put("msg", "修改成功");
      } else {
        map.put("code", 1);
        map.put("msg", "修改失败");
      }

    }
    return map;
  }

  //用户Id查角色
  @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getUserId(String userId) {
    //  通过用户Id查询到角色
    List<SysRoleUser> list = sysRoleUserService.getUserId(userId);
    Map<String, Object> map = new HashMap<String,Object>();
    for (SysRoleUser sysRoleUser : list) {
      List<SysUserMenuPower> byBrowser = sysUserMenuPowerService.getByBrowser(sysRoleUser.getRoleId());
      List<SysRoleMenuPower> list1 = new ArrayList<SysRoleMenuPower>();
      for (SysRoleMenuPower sysRoleMenuPower : byBrowser) {
        if (sysRoleMenuPower.getMenuPowerId() == null) {
          list1.add(sysRoleMenuPower);
        }
      }
      byBrowser.removeAll(list1);
      if (byBrowser != null) {
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("data", byBrowser);
      } else {
        map.put("code", 1);
        map.put("msg", "查询失败");
      }
    }
    return map;
  }
}
