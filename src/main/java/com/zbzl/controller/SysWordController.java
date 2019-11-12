package com.zbzl.controller;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysFile;
import com.zbzl.entity.SysWord;
import com.zbzl.service.SysFileService;
import com.zbzl.service.SysUserService;
import com.zbzl.service.SysWordService;
import com.zbzl.until.Download;
import com.zbzl.until.FileUntil;
import com.zbzl.until.ServerConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysWordController {
  @Autowired
  private SysWordService sysWordService;
  @Autowired
  private SysUserService sysUserService;
  @Autowired
  private SysFileService sysFileService;


  //分页查询
  @RequestMapping(value = "/getWordALL", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getWordALL(PageQuery pageQuery ) {
    String Temp = "";
    StringBuilder buf = new StringBuilder();
    String name = pageQuery.getName();
    String zlfl = pageQuery.getZlfl();
    String zwdw = pageQuery.getZwdw();
    String zlbq = pageQuery.getZlbq();
    String time = pageQuery.getTime();
    if (name!=null&&name!=""){
      buf.append("word_name like '%"+name+"%' or");
    }
    if (zlfl!=null&&zlfl!=""){
      buf.append(" WORD_CLASSIFY like '%"+zlfl+"%' or");
    }
    if (zwdw!=null&&zwdw!=""){
      buf.append(" WORD_ORG like '%"+zwdw+"%' or");
    }
    if (zlbq!=null&&zlbq!=""){
      buf.append(" WORD_LABEL like '%"+zlbq+"%' or");
    }
    if (time!=null&&time!=""){
      buf.append("  WORD_TIME like '%"+time+"%' or");
    }
    String d="";
    if (buf.length()>0){
       d=buf.toString().substring(0,buf.length()-2);
    }
    if (!d.equals("")){
    Temp += " and "+ "("+d+")";
    }
    pageQuery.setExSql(Temp);
    List<SysWord> pageInfo = sysWordService.selectByExample(pageQuery);

      int listSize = sysWordService.selectCountByExample(pageQuery);
      Map<String, Object> map = new HashMap<String, Object>();
      if (listSize >= 0) {
        map.put("code", 0);
        map.put("msg", "查询成功");
        map.put("count", listSize);
        map.put("data", pageInfo);
      } else {
        map.put("code", 1);
        map.put("msg", "查询失败");
      }return map;
    }

  //  删除
  @RequestMapping(value = "/getWordDelete",method = RequestMethod.GET)
  @ResponseBody
  public Map<Object, Object> getWordDelete(String ids) {
    Map<Object, Object> map = new HashMap<Object, Object>();
    PageQuery pageQuery = new PageQuery();
    String Temp = "";
    Temp = "("+ids+")";
    pageQuery.setExSql(Temp);
    List<SysFile> sysFiles = sysFileService.selectFileById(ids);
    for (SysFile files : sysFiles){
      File file = new File( files.getFileHerf());
      file.delete();
    }
    //调用业务
    int temp=sysWordService.deleteMoreDistrict(pageQuery);
    if (temp>0){
      map.put("code",0);
      map.put("msg","删除成功！");
    }else {
      map.put("code",1);
      map.put("msg","修改失败！");
    }
    return map;
  }

 //文件上传
 @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
 @ResponseBody
 public Map<String,Object>  uploadFile(HttpServletRequest request , @RequestParam(value = "filename") MultipartFile fileName ) {
   FileUntil fileUntil=new FileUntil();
   String savePath = null;
   String file_name = fileName.getOriginalFilename();
   Map<String,Object> map =new HashMap<String,Object>();
   if(file_name.indexOf(".") == -1){
     map.put("code",1);
     map.put("msg","文件格式不正确");
     map.put("data",null);
     return map;
   }else{
     savePath = fileUntil.uploadFile(request,fileName);
   }
   if (savePath!=null){
     map.put("code",0);
     map.put("msg","上传成功");
     map.put("data",savePath);
   }else {
     map.put("code",1);
     map.put("msg","上传失败");
     map.put("data","文件名重复或其他原因");
   }
    return map;
 }


 //文件下载
  @RequestMapping("/DownloadFile")
  @ResponseBody
  public Map<Object,Object> downloadFile(@Param("fileId") String fileId, HttpServletRequest req, HttpServletResponse res) throws IOException {
    SysFile sysFile = sysFileService.selectFileAll(fileId);
      String name =sysFile.getFileHerf();
      String downloadName =sysFile.getFileName();
      Download.download(res, name, downloadName);

    Map<Object,Object>map =new HashMap<Object,Object>();
    if (sysFile!=null){
      map.put("code",0);
      map.put("msg","下载成功");
    }else {
      map.put("code",1);
      map.put("msg","下载失败");
    }return map;
  }

  //添加
  @RequestMapping(value = "/getWordAdd",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getWordAdd(@RequestBody SysWord sysWord)  {
    Map<Object, Object> map = new HashMap<Object,Object>();
    String temp =  sysUserService.getDataByExmple("word_id","sys_word","word_name",sysWord.getWordName());
    if( temp != null ){
      map.put("code", 1);
      map.put("msg", "文件名重复，请重新输入");
      return map;
    }
    ServerConfig serverConfig= new ServerConfig();
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
    Date date = new Date();
    String time = sdf.format(date);
    sysWord.setWordTime(time);
    int word = sysWordService.getMaxId()+1;
    String word_id = word+"";
    sysWord.setWordId(word_id);
    int insert = sysWordService.insert(sysWord);
   //字表
    List<SysFile> sysFiles = sysWord.getSysFiles();
    if (sysFiles != null && sysFiles.size() > 0) {
      for (SysFile sysFile:sysFiles){
        int role = sysFileService.getMaxId()+1;
        String file_id = role+"";
        sysFile.setFileId(file_id);
        sysFile.setMenuId(word_id);
        sysFile.setFileServer(serverConfig.getUrl()+":8080"+"/uploadFiles/"+sysFile.getFileName());
        int insert1 = sysFileService.insert(sysFile);
      }
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
  @RequestMapping(value = "/getWordUpdate",method = RequestMethod.POST,consumes = "application/json")
  @ResponseBody
  public Map<Object, Object> getWordUpdate(@RequestBody SysWord sysWord ) {
    Map<Object, Object> map = new HashMap<Object,Object>();
    ServerConfig serverConfig= new ServerConfig();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String time = sdf.format(date);
    sysWord.setWordTime(time);


    int i = sysFileService.deleteByPrimaryKey(sysWord.getWordId());
    List<SysFile> sysFiles = sysWord.getSysFiles();
    if (sysFiles != null && sysFiles.size() > 0) {
      for (SysFile sysFile : sysFiles) {
        int role = sysFileService.getMaxId()+1;
        String file_id = role+"";
        sysFile.setFileId(file_id);
        sysFile.setMenuId(sysWord.getWordId());
        sysFile.setFileServer(serverConfig.getUrl()+":8080"+"/uploadFiles/"+sysFile.getFileName());
        int insert1 = sysFileService.insert(sysFile);

      if (i != 0) {
        map.put("code", 0);
        map.put("msg", "修改成功");
      } else {
        map.put("code", 1);
        map.put("msg", "修改失败");
      }
  }
    }
    return map;
  }
}
