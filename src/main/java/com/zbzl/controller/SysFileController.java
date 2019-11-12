package com.zbzl.controller;

import com.zbzl.entity.SysFile;
import com.zbzl.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class SysFileController {

 @Autowired
private SysFileService sysFileService;



  //  通过文档Id查询
  @RequestMapping(value = "/selectFileById", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> selectFileById(String wordId) {
    List<SysFile> sysFiles = sysFileService.selectFileById(wordId);
   Map<Object, Object> map = new HashMap<Object,Object>();
    if (sysFiles != null) {
      map.put("code", 0);
      map.put("msg", "查询成功！");
      map.put("data", sysFiles);
    } else {
      map.put("code", 0);
      map.put("msg", "查询失败！");
    }
    return map;
  }

//通过附件Id查询
  @RequestMapping(value = "/selectFileAll", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> selectFileAll(String fileId) {
    SysFile sysFile = sysFileService.selectFileAll(fileId);
   Map<Object, Object> map = new HashMap<Object,Object>();
    if (sysFile != null) {
      map.put("code", 0);
      map.put("msg", "查询成功！");
      map.put("data", sysFile);
    } else {
      map.put("code", 0);
      map.put("msg", "查询失败！");
    }
    return map;
  }

//获取在线预览地址
  @RequestMapping(value = "/getFileHerf", method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getFileHerf(String fileId){
    SysFile fileHerf = sysFileService.getFileHerf(fileId);
    fileHerf.getFileServer();
   Map<Object, Object> map = new HashMap<Object,Object>();
    if (fileHerf !=null) {
      map.put("code", 0);
      map.put("msg", "查询成功！");
      map.put("data", fileHerf.getFileServer());
    } else {
      map.put("code", 0);
      map.put("msg", "查询失败！");
    }
    return map;
  }


    //删除本地文件
    @RequestMapping("/deletBd")
    @ResponseBody
    public Map<String,Object> deletBd(String fileId){
        Map<String,Object> map = new HashMap<String, Object>();
        SysFile sysFile = sysFileService.selectFileAll(fileId);
        File file = new File(sysFile.getFileHerf());
        file.delete();
        int i = sysFileService.deleteBd(fileId);
        if (i>0){
            map.put("code",0);
            map.put("msg","删除成功");
            map.put("data",i);
        }else {
            map.put("code",1);
            map.put("msg","删除失败");
        }
        return map;
    }
}
