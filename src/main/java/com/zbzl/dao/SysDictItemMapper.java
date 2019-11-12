package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysDictItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysDictItemMapper {
    int deleteByPrimaryKey(String itemId);

    int insert(SysDictItem record);

    int insertSelective(SysDictItem record);

    SysDictItem selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(SysDictItem record);

    int updateByPrimaryKey(SysDictItem record);
    //通过字典id查询
    List<SysDictItem> selectByDictId(String dictId);


    List<SysDictItem> selectByExample(PageQuery pageQuery);
    //获取总条数
    int selectCountByExample(PageQuery pageQuery);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    int getMaxId();

    int  deleteByDictId(String dictId);

    //通过字典项Id查询字典项
    List<SysDictItem>  getDictItemById(String itemId);
    //通过字典表Id查询
    List<SysDictItem> getByName(String dictId);
}