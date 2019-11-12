package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    //  分页
    List<SysRole> selectByExample(PageQuery pageQuery);
    //增加条件语句
    int selectCountByExample(PageQuery pageQuery);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    int getMaxId();

}