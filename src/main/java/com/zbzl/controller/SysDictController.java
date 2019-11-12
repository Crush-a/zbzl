package com.zbzl.controller;//package com.example.demo01.controller;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDict;
import com.zbzl.entity.SysDictItem;
import com.zbzl.service.SysDictItemService;
import com.zbzl.service.SysDictService;
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
public class SysDictController {

@Autowired
  private SysDictService sysDictService;
@Autowired
  private SysDictItemService sysDictItemService;
@Autowired
  private SysUserService sysUserService;

//  分页查询
  @RequestMapping(value = "/getSysDictAll",method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getALL(PageQuery pageQuery) {
    String Temp = "";
    if("".equals(pageQuery.getName()) || pageQuery.getName() != null){
      Temp += " and dict_name like '%"+pageQuery.getName()+"%'";
    }
    pageQuery.setExSql(Temp);
    List<SysDict> pageInfo = sysDictService.selectByExample(pageQuery);
    int listSize = sysDictService.selectCountByExample(pageQuery);
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
  @RequestMapping(value = "/getSysDictById",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> getById(String dictId){
    SysDict sysDict = sysDictService.selectByPrimaryKey(dictId);
    Map<Object,Object> map =new HashMap<Object,Object>();
    if (sysDict!=null){
      map.put("code", 0);
      map.put("msg", "查询成功");
      map.put("data", sysDict);
    }else {
      map.put("code", 1);
      map.put("msg", "查询失败");
    }
    return map ;
  }

   // 删除
  @RequestMapping(value = "/getSysDictDelete",method = RequestMethod.GET)
 @ResponseBody
  public Map<Object, Object> deletBy(String ids) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    PageQuery pageQuery = new PageQuery();
    String Temp = "";
    Temp = "("+ids+")";
    pageQuery.setExSql(Temp);
    //调用业务
    int temp=sysDictService.deleteMoreDistrict(pageQuery);
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
  @RequestMapping(value = "/getSysDictAdd",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
    public Map<Object, Object> getAdd(@RequestBody SysDict sysDict) {
   Map<Object, Object> map = new HashMap<Object,Object>();
    String temp = sysUserService.getDataByExmple("dict_id", "sys_dict", "dict_name", sysDict.getDictName());
    if (!"".equals(temp) || temp != null || !"null".equals(temp)) {
      map.put("code", 1);
      map.put("msg", "字典名称重复，请重新输入");
      return map;}
      int dictMax = sysDictService.getMaxId() + 1;
      String dict_id = dictMax + "";
      sysDict.setDictId(dict_id);
      int insert = sysDictService.insertSelective(sysDict);
      //子表
      List<SysDictItem> list = sysDict.getSysDictItems();
      if (list != null && list.size() > 0) {
        for (SysDictItem sysDictItem : list) {
          int itemMax = sysDictItemService.getMaxId() + 1;
          String item_id = itemMax + "";
          sysDictItem.setItemId(item_id);
          sysDictItem.setDictId(dict_id);
          sysDictItem.setDictCode(sysDict.getDictCode());
          int i = sysDictItemService.insert(sysDictItem);
        }
      }
      if (insert > 0) {
        map.put("code", 0);
        map.put("msg", "添加成功");
      } else {
        map.put("code", 1);
        map.put("msg", "添加失败");
    }return map;
  }

//  修改
  @RequestMapping(value = "/getSysDictUpdate",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getSysDictUpdate(@RequestBody SysDict sysDict){
    Map<Object,Object> map =new HashMap<Object,Object>();
    String dictId = sysDict.getDictId();
    int i2 = sysDictItemService.deleteByDictId(dictId);
    int i1 = sysDictService.updateByPrimaryKeySelective(sysDict);
    //子表
    List<SysDictItem> list = sysDict.getSysDictItems();
    if (list !=null && list.size()>0){
    for (SysDictItem sysDictItem:list){
      int itemMax = sysDictItemService.getMaxId()+1;
      String item_id = itemMax+"";
      sysDictItem.setItemId(item_id);
      sysDictItem.setDictId(sysDict.getDictId());
      sysDictItem.setDictCode(sysDict.getDictCode());
      int i = sysDictItemService.insert(sysDictItem);
    }
  }
    if( i1> 0){
    map.put("code", 0);
    map.put("msg", "添加成功");
  }else{
    map.put("code", 1);
    map.put("msg", "添加失败");
  }
    return map;
}

//通过特殊符号查询
  @RequestMapping(value = "/getDictName",method = RequestMethod.GET)
  @ResponseBody
  public Map<String,Object> getDictName(String dictTs){
    List<SysDict> dictName = sysDictService.getDictName(dictTs);
  Map<String ,Object> map =new HashMap<String,Object>();
    if( dictName!= null){
      map.put("code", 0);
      map.put("msg", "查询成功");
      map.put("data",dictName);
    }else{
      map.put("code", 1);
      map.put("msg", "查询失败");
    }
    return map;
  }

  //通过字典表id查询
  @RequestMapping(value = "/getDictById",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object,Object> getDictById(String dictId){
    List<SysDict> dictById = sysDictService.getDictById(dictId);
    Map<Object ,Object> map =new HashMap<Object,Object>();
    if( dictById!=null){
      map.put("code", 0);
      map.put("msg", "查询成功");
      map.put("data",dictById);
    }else{
      map.put("code", 1);
      map.put("msg", "查询失败");
    }
    return map;
  }
}
