package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserMapper {
    //删除
    int deleteByPrimaryKey(String userId);

    //  增加
    int insertSelective(SysUser record);

    //查询单条
    SysUser selectByPrimaryKey(String userId);

    //修改
    int updateByPrimaryKeySelective(SysUser sysUser);

    //  分页
    List<SysUser> selectByExample(PageQuery pageQuery);
    //获取总条数
    int selectCountByExample(PageQuery pageQuery);

    //  登录@Mapper
    SysUser login(SysUser sysUser);

    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);

    //修改密码
    int updateByUserPass(String userId, String newPass);

    int getMaxId();
    //查重
    String getDataByExmple(@Param("outCol") String outCol, @Param("tableName")String tableName,@Param("inCol") String inCol,@Param("inData") String inData);



}