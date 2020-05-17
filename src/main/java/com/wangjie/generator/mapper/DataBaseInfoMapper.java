package com.wangjie.generator.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DataBaseInfoMapper
 * @Description 用于获取目标数据库的信息
 * @Author wangjie
 * @Date 2020/5/16 6:22 下午
 * @Email wangjie_fourth@163.com
 **/
@Mapper
@Repository
public interface DataBaseInfoMapper {


    /**
     * 查询这个表的基本信息
     *
     * @param tableName 不含schema的表名
     * @return  表的信息
     */
    Map<String, String> queryTable(String tableName);

    /**
     * 查询这个表的所有列信息
     *
     * @param tableName 不含schema的表名
     * @return  表的所有列信息
     */
    List<Map<String, String>> queryColumns(String tableName);

    /**
     * 查询这个数据库的所有表，除去flyway表
     *
     * @param map   查询条件
     * @return      数据库表的所有信息
     */
    List<Map<String, Object>> queryTableList(Map<String, Object> map);

}
