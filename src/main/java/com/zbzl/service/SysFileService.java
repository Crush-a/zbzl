package com.zbzl.service;

import com.zbzl.entity.SysFile;

import java.util.List;

public interface SysFileService {

  //通过文档id查所有
  List<SysFile> selectFileById(String wordId);

  int getMaxId();
  //增加
  int insert(SysFile sysFile);
  //通过附件id查询单条
  SysFile  selectFileAll(String fileId);
  //删除
  int deleteByPrimaryKey(String wordId);

  SysFile  getFileHerf(String fileId);

  //删除本地文件
  int deleteBd (String FileId);
}
