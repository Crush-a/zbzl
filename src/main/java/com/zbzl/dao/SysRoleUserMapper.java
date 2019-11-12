package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysRoleUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleUserMapper {
    int deleteByPrimaryKey(String roleUserId);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    SysRoleUser selectByPrimaryKey(String roleUserId);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);

    //  分页
    List<SysRoleUser> selectByExample(PageQuery pageQuery);
   //增加查询条件
    int selectCountByExample(PageQuery pageQuery);

    int  deleteByRoleId(String roleId);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    int getMaxId();

    //通过用户Id查角色
    List<SysRoleUser> getUserId(String userId);

    List<SysRoleUser> selectByRoleId (String roleId);


}