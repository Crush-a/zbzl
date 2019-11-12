package com.zbzl.controller;


import com.zbzl.entity.SysMenuPower;
import com.zbzl.service.SysMenuPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysMenuPowerController {

@Autowired
  private SysMenuPowerService sysMenuPowerService;

  //查询
  @RequestMapping(value = "/getMenuPower",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> getMenuPower(SysMenuPower sysMenuPower, String powerId){
    //通过权限Id查到菜单
    List<SysMenuPower> menuPower = sysMenuPowerService.getMenuPower(powerId);
    Map<Object,Object> map =new HashMap<Object,Object>();
    if(menuPower!=null){
      map.put("code",0);
      map.put("msg","查询成功！");
    }else {
      map.put("code",1);
      map.put("msg","查询失败");
    }
    return map;
  }

 //  单条查询
  @RequestMapping(value = "/getMenuPowerById",method = RequestMethod.GET)
  @ResponseBody
  public SysMenuPower getById(String menuPowerId){
    SysMenuPower sysMenuPower = sysMenuPowerService.selectByPrimaryKey(menuPowerId);
    return sysMenuPower;
  }



}
