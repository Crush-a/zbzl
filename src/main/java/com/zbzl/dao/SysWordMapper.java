package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysWordMapper {
    int deleteByPrimaryKey(String wordId);

    int insert(SysWord record);

    int insertSelective(SysWord record);

    SysWord selectByPrimaryKey(String wordId);

    int updateByPrimaryKey(SysWord record);
    //  分页
    List<SysWord> selectByExample(PageQuery pageQuery);
    //增加条件查询
    int selectCountByExample(PageQuery pageQuery);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    int getMaxId();

    List<SysWord> selectMh(PageQuery pageQuery);


}