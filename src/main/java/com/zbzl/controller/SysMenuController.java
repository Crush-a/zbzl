package com.zbzl.controller;//package com.example.demo01.controller;


import com.zbzl.entity.SysMenu;
import com.zbzl.service.SysMenuService;
import com.zbzl.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
  public class SysMenuController {

@Autowired
  private SysMenuService sysMenuService;
@Autowired
  private SysUserService sysUserService;

  //  查询
  @RequestMapping(value = "/getMenu",method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getMenu() {
    List<SysMenu> sysMenus = sysMenuService.selectAll();
    Map<String, Object> map = new HashMap<String,Object>();
    if (sysMenus != null) {
      map.put("code", 0);
      map.put("msg", "查询成功");
      map.put("count", sysMenus);
      map.put("data", sysMenus);
    } else {
      map.put("code", 1);
      map.put("msg", "查询失败");

    }
    return map;
  }

  //查询单条
  @RequestMapping(value = "/getMenuById",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> getMenuById(String menuId) {
    SysMenu sysMenu = sysMenuService.selectByPrimaryKey(menuId);
   Map<Object, Object> map = new HashMap<Object,Object>();
  if (sysMenu != null) {
    map.put("code", 0);
    map.put("msg", "查询成功！");
    map.put("data", sysMenu);
  } else {
    map.put("code", 1);
    map.put("msg", "查询失败！");
  }return map;
}

  //  修改
  @RequestMapping(value = "/getMenuUpdate",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getMenuUpdate(SysMenu sysMenu) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    int i = sysMenuService.updateByPrimaryKeySelective(sysMenu);
  if (i > 0) {
    map.put("code", 0);
    map.put("msg", "修改成功");
  } else {
    map.put("code", 1);
    map.put("msg", "修改失败");
  }
    return map;
  }
}
