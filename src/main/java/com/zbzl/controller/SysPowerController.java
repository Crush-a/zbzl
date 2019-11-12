package com.zbzl.controller;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysPower;
import com.zbzl.service.SysPowerService;
import com.zbzl.service.SysRoleService;
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
public class SysPowerController {
  @Autowired
  private SysPowerService sysPowerService;
  @Autowired
  private SysRoleService sysRoleService;
  @Autowired
  private SysUserService sysUserService;

  //  分页查询
  @RequestMapping(value = "/getPowerAll", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getALL(PageQuery pageQuery) {
      String Temp = "";
    if ("".equals(pageQuery.getName()) || pageQuery.getName() != null) {
      Temp += " and power_name like '%" + pageQuery.getName() + "%'";
    }
      pageQuery.setExSql(Temp);
      List<SysPower> pageInfo = sysPowerService.selectByExample(pageQuery);
      int listSize = sysPowerService.selectCountByExample(pageQuery);
      Map<String, Object> map = new HashMap<String,Object>();
    if (listSize >= 0) {
      map.put("code", 0);
      map.put("msg", "查询成功");
      map.put("count", listSize);
      map.put("data", pageInfo);
    } else {
      map.put("code", 1);
      map.put("msg", "查询失败");
    }
    return map;
  }

  //  查询单条
  @RequestMapping(value = "/getPowerById", method = RequestMethod.GET)
  @ResponseBody
  public SysPower getById(String powerId) {
    SysPower sysPower = sysPowerService.selectByPrimaryKey(powerId);
   return sysPower;
  }

  //  删除
  @RequestMapping(value = "/getPowerDelete", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> deletBy(String ids) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    PageQuery pageQuery = new PageQuery();
    String Temp = "";
    Temp = "(" + ids + ")";
    pageQuery.setExSql(Temp);
    //调用业务
    int temp = sysPowerService.deleteMoreDistrict(pageQuery);
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
  @RequestMapping(value = "/getPowerAdd", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getAdd(SysPower sysPower) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    String temp = sysUserService.getDataByExmple("power_id", "sys_power", "power_name", sysPower.getPowerName());
    if (!"".equals(temp) || temp != null || !"null".equals(temp)) {
      map.put("code", 1);
      map.put("msg", "权限名重复，请重新输入");
      return map;
    }
    int dictMax = sysPowerService.getMaxId() + 1;
    String power_id = dictMax + "";
    sysPower.setPowerId(power_id);
    int insert = sysPowerService.insert(sysPower);
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
  @RequestMapping(value = "/getPowerUpdate", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getUpdate(SysPower sysPower) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    int i = sysPowerService.updateByPrimaryKeySelective(sysPower);
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











