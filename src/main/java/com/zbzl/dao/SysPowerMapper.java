package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysPower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysPowerMapper {
    int deleteByPrimaryKey(String powerId);

    int insert(SysPower record);

    int insertSelective(SysPower record);

    SysPower selectByPrimaryKey(String powerId);

    int updateByPrimaryKeySelective(SysPower record);

    int updateByPrimaryKey(SysPower record);

    //  分页
    List<SysPower> selectByExample(PageQuery pageQuery);
    //获取总条数
    int selectCountByExample(PageQuery pageQuery);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    int getMaxId();
    //不分页查询所有
    List<SysPower>  selectAll ();
}