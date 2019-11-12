package com.zbzl.until;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件操作相关接口工具类
 * @author yangzhiyao
 * @version 1.0
 */
public class FileUntil {

  /**
   * 文件上传通用接口
   *
   * @param request
   * @param fileName
   * @return
   */

  public String uploadFile(HttpServletRequest request, MultipartFile fileName) {
    OutputStream os = null;
    InputStream in = null;
    Map<Object,Object> map =new HashMap<Object,Object>();
    try {
      File file1 = new File("");
      String path1 = file1.getAbsolutePath();
      String substring = path1.substring(0, 36);
      String config = substring + "/uploadFiles/";
      File uploadDir = new File(config);
      if (!uploadDir.exists() && !uploadDir.isDirectory()) {
        uploadDir.mkdir();
      }
      String oldfilename = fileName.getOriginalFilename();
      int end = oldfilename.length();
      int i = oldfilename.indexOf(".");
      String Exe = oldfilename.substring(i, end);
      String savePath = config + fileName.getOriginalFilename().substring(0, fileName.getOriginalFilename()
        .indexOf("."))  + Exe;
      File file = new File(savePath);
     if (file.exists()==false){
      in = fileName.getInputStream();
      os = new FileOutputStream(file);
      int bytesRead = 0;
      int fileSize = (int) fileName.getSize();
      byte[] buffer = new byte[1024000000];
      while ((bytesRead = in.read(buffer, 0, fileSize)) != -1) {
        os.write(buffer, 0, bytesRead);
      }
      os.close();
      in.close();
      return savePath;
    }
     else {
       return null;

     }
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
