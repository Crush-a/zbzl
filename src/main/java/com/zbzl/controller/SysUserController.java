package com.zbzl.controller;


import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysUser;
import com.zbzl.service.SysUserService;
import com.zbzl.until.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class SysUserController {

  @Autowired
  private SysUserService sysUserService;



 //跳转登陆页面
  @RequestMapping(value = "/toLogin")
  public String toLogin(){
    return "login";
  }

  //跳转页面
  @RequestMapping(value = "/toIndex")
  public String toIndex(){
    return "index";
  }

  //分页查询
  @RequestMapping(value = "/getALL", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getALL(PageQuery pageQuery) {
    String Temp = "";
    if("".equals(pageQuery.getName()) || pageQuery.getName() != null){
      Temp += " and user_name like '%"+pageQuery.getName()+"%'";
    }
    pageQuery.setExSql(Temp);
    List<SysUser> pageInfo = sysUserService.selectByExample(pageQuery);
    int listSize = sysUserService.selectCountByExample(pageQuery);
    Map<String, Object> map = new HashMap<String, Object>();
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
  @RequestMapping(value = "/getById", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getById( String userId) {
    SysUser l = sysUserService.selectByPrimaryKey(userId);
    Map<Object, Object> map = new HashMap<Object,Object>();
    map.put("code", 0);
    map.put("msg", "");
    map.put("date", l);
    return map;
  }

  //删除
  @RequestMapping(value = "/getDeleteBy", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> deletBy(String ids) {
    Map<Object, Object> map = new HashMap<Object,Object>();
    PageQuery pageQuery = new PageQuery();
    String Temp = "";
    Temp = "("+ids+")";
    pageQuery.setExSql(Temp);
    //调用业务
    int temp=sysUserService.deleteMoreDistrict(pageQuery);
    if (temp>0){
      map.put("code",0);
      map.put("msg","删除成功！");
    }else {
      map.put("code",1);
      map.put("msg","修改失败！");
    }
    return map;
  }

  //修改密码
  @RequestMapping(value = "updateByUserPass",method = RequestMethod.GET)
  @ResponseBody
  public Object updatePassWord(String userId, String newPass){
    Map<String,Object> map=new HashMap<String,Object>();
    int i= sysUserService.updateByUserPass(userId,newPass);

    if(i>0){
      map.put("code",0);
      map.put("msg","修改成功！");
    }else {
      map.put("code",1);
      map.put("msg","修改失败");
    }
    return map;
  }

//修改
  @RequestMapping(value = "/getUpdate", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getUpdate(SysUser sysUser) {

    Map<Object, Object> map = new HashMap<Object,Object>();
    int i = sysUserService.updateByPrimaryKeySelective(sysUser);
    if (i > 0) {
      map.put("code", 0);
      map.put("msg", "修改成功");
    } else{
      map.put("code", 1);
      map.put("msg", "修改失败");
    }
    return map;
  }

  //  添加
  @RequestMapping(value = "/getAdd", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getAdd(SysUser sysUser) {
    Map<Object, Object> map = new HashMap<Object,Object>();
    String temp =  sysUserService.getDataByExmple("user_code","sys_user","user_login",sysUser.getUserLogin());
    if(temp != null){
      map.put("code", 1);
      map.put("msg", "用户名重复，请重新输入");
      return map;
    }

    if ("".equals(sysUser.getUserPass()) || sysUser.getUserPass() == null) {
      sysUser.setUserPass(MD5Utils.md5Encrypt("1234"));
    }
    int max = sysUserService.getMaxId()+1;
    String user_id = max+"";
    sysUser.setUserId(user_id);
    int insert = sysUserService.insertSelective(sysUser);
    if(insert > 0){
      map.put("code", 0);
      map.put("msg", "添加成功");
    }else{
      map.put("code", 1);
      map.put("msg", "添加失败");
    }
    return map;
  }



  /**
   * 用户登录
   *
   * @param userLogin
   * @param userPass
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  @ResponseBody
  public  Map<Object, Object> login(String userLogin, String userPass) {
    Map<Object, Object> map = new HashMap<Object,Object>();
    SysUser sysUser = new SysUser();
    sysUser.setUserLogin(userLogin);
    sysUser.setUserPass(MD5Utils.md5Encrypt(userPass));
    SysUser sysUser1 = sysUserService.login(sysUser);
    if(sysUser1!=null){
      map.put("code", 0);
      map.put("msg", "登陆成功");
      map.put("data",sysUser1);
    }else{
      map.put("code", 1);
      map.put("msg", "登陆失败");
    }
    return map;
  }

}