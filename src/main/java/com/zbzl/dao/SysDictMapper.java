package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysDictMapper {
    int deleteByPrimaryKey(String dictId);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(String dictId);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    //  分页
    List<SysDict> selectByExample(PageQuery pageQuery);
    //获取总条数
    int selectCountByExample(PageQuery pageQuery);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    int getMaxId();

    //通过特殊符号查询
    List<SysDict> getDictName(String dictTs);
    //通过字典表Id查询字典表
   List<SysDict> getDictById(String dictId);
}