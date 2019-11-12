package com.zbzl.service.Impl;

import com.zbzl.dao.SysFileMapper;
import com.zbzl.entity.SysFile;
import com.zbzl.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysFileServiceImpl implements SysFileService {

  @Autowired
  private SysFileMapper sysFileMapper;


  @Override
  public List<SysFile> selectFileById(String wordId) {
    return sysFileMapper.selectFileById(wordId);
  }

  @Override
  public int getMaxId() {
    return sysFileMapper.getMaxId();
  }

  @Override
  public int insert(SysFile sysFile) {
    return sysFileMapper.insert(sysFile);
  }

  @Override
  public SysFile selectFileAll(String fileId) {
    return sysFileMapper.selectFileAll(fileId);
  }

  @Override
  public int deleteByPrimaryKey(String wordId) {
    return sysFileMapper.deleteByPrimaryKey(wordId);
  }

  @Override
  public SysFile getFileHerf(String fileId) {
    return sysFileMapper.getFileHerf(fileId);
  }
  @Override
  public int deleteBd(String FileId) {
    return sysFileMapper.deleteBd(FileId);
  }

}



