package com.zbzl.dao;

import com.zbzl.entity.PageQuery;
import com.zbzl.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    //查询到所有菜单；不分页
    List<SysMenu>  selectAll ();
    //分页查询所有菜单
    List<SysMenu> selectByExample(PageQuery pageQuery);
    //获取总条数
    int selectCountByExample(PageQuery pageQuery);
    //获取最大值
    int getMaxId();
    //批量删除
    int deleteMoreDistrict(PageQuery pageQuery);
    //通过菜单名称查询到数据
    List<SysMenu> selectByMenuName(String menuName);
}