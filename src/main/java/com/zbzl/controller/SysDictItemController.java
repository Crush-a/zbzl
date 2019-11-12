package com.zbzl.controller;//package com.example.demo01.controller;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDict;
import com.zbzl.entity.SysDictItem;
import com.zbzl.service.SysDictItemService;
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
public class SysDictItemController {

@Autowired
  private SysDictItemService sysDictItemService;
@Autowired
  private SysUserService sysUserService;
  //  查询
  @RequestMapping(value = "/getDictltemAll", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getDictltemAll(String dictId) {
    List<SysDictItem> sysDictItems = sysDictItemService.selectByDictId(dictId);
   Map<Object, Object> map = new HashMap<Object,Object>();
    if (sysDictItems != null) {
      map.put("code", 0);
      map.put("msg", "查询成功！");
      map.put("data", sysDictItems);
    } else {
      map.put("code", 0);
      map.put("msg", "查询失败！");
    }
    return map;
  }

  //  查询单条
  @RequestMapping(value = "/getDictltemById",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> getById(String itemId) {
    SysDictItem sysDictItem = sysDictItemService.selectByPrimaryKey(itemId);
   Map<Object, Object> map = new HashMap<Object,Object>();
    if (sysDictItem!=null){
      map.put("code",0);
      map.put("msg","查询成功！");
      map.put("data",sysDictItem);
    }else {
      map.put("code",0);
      map.put("msg","查询失败！");
    }
    return map;
  }

  //  删除
  @RequestMapping(value = "/getDictltemDelete",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> deletBy(String ids) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    PageQuery pageQuery = new PageQuery();
    String Temp = "";
    Temp = "(" + ids + ")";
    pageQuery.setExSql(Temp);
    //调用业务
    int temp = sysDictItemService.deleteMoreDistrict(pageQuery);
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
  @RequestMapping(value = "/getDictltemAdd",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getAdd(SysDictItem sysDictItem) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    String temp = sysUserService.getDataByExmple("item_id","sys_dict_item","item_name",sysDictItem.getItemName());
    if(!"".equals(temp)||temp!=null||!"null".equals(temp)){
      map.put("code", 1);
      map.put("msg", "字典项名称重复，请重新输入");
      return map;
    }
    int dict_item_Max = sysDictItemService.getMaxId() + 1;
    String dict_item_id = dict_item_Max + "";
    sysDictItem.setItemId(dict_item_id);
    int insert = sysDictItemService.insert(sysDictItem);
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
  @RequestMapping(value = "/getDictltemUpdate",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getUpdate(SysDictItem sysDictItem, SysDict sysDict) {
  Map<Object, Object> map = new HashMap<Object,Object>();

    String dictId = sysDict.getDictId();
    int i2 = sysDictItemService.deleteByDictId(dictId);
    int insert = sysDictItemService.insert(sysDictItem);
    if (insert > 0) {
      map.put("code", 0);
      map.put("msg", "修改成功");
    } else {
      map.put("code", 1);
      map.put("msg", "修改失败");
    }
    return map;
  }

  //通过字典id在字典项中查询
  @RequestMapping(value = "/selectByName",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> selectByName(String dictId) {
    List<SysDictItem> sysDictItems = sysDictItemService.getByName(dictId);
   Map<Object, Object> map = new HashMap<Object,Object>();
    if (sysDictItems!=null){
      map.put("code",0);
      map.put("msg","查询成功！");
      map.put("data",sysDictItems);
    }else {
      map.put("code",0);
      map.put("msg","查询失败！");
    }
    return map;
  }

//通过字典表Id在字典项中查询，通过字典项id查询到单条
  @RequestMapping(value = "/getDictItemById",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> getDictItemById(String dictId){
    List<SysDictItem> dictItemById = sysDictItemService.getByName(dictId);
    Map<Object,Object> map =new HashMap<Object,Object>();
    for (SysDictItem sysDictItem:dictItemById){
      List<SysDictItem> dictItemById1 = sysDictItemService.getDictItemById(sysDictItem.getItemId());
     if (dictItemById1!=null){
       map.put("code",0);
       map.put("msg","查询成功！");
       map.put("data",dictItemById1);
     }else {
       map.put("code",0);
       map.put("msg","查询失败！");
     }
    }
   return map;
  }


}
