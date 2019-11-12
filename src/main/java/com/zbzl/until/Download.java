package com.zbzl.until;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
/*
 * @param resp
  * @param name         文件真实名字
  * @param downloadName 文件下载时名字
  */
public class Download {
       public static void download(HttpServletResponse resp, String name, String downloadName) {
         String fileName = null;
         try {
           fileName = new String(downloadName.getBytes("GBK"), "ISO-8859-1");
         } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
         }
         String config = name;
         File uploadDir = new File(config);
         if (!uploadDir.exists() && !uploadDir.isDirectory()) {
           uploadDir.mkdir();
         }
         resp.reset();
         resp.setContentType("application/octet-stream");
         resp.setCharacterEncoding("utf-8");
         resp.setContentLength((int) uploadDir.length());
         resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
         byte[] buff = new byte[1024];
         BufferedInputStream bis = null;
         OutputStream os = null;
         try {
           os = resp.getOutputStream();
           bis = new BufferedInputStream(new FileInputStream(uploadDir));
           int i = 0;
           while ((i = bis.read(buff)) != -1) {
             os.write(buff, 0, i);
             os.flush();
           }
         } catch (IOException e) {
           e.printStackTrace();
         } finally {
           try {
             bis.close();
           } catch (IOException e) {
             e.printStackTrace();
           }
         }
       }
}
