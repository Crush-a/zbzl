package com.zbzl.dao;

import com.zbzl.entity.SysFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysFileMapper {

//通过文档id查所有
 List<SysFile> selectFileById(String wordId);
//通过附件Id查询
 SysFile  selectFileAll(String fileId);

 int getMaxId();
 //增加
 int insert(SysFile sysFile);
//通过附件ID删除
 int deleteByPrimaryKey(String wordId);

 SysFile  getFileHerf(String fileId);

 //删除本地文件
 int deleteBd (String FileId);
}
