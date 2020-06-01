package com.wangjie.generator.mapper;

import com.wangjie.generator.model.db.Column;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @ClassName ColumnMapper
 * @Description 
 * @Author wangjie
 * @Date 2020/5/22 9:46 上午
 * @Email wangjie_fourth@163.com
 **/
@Mapper
@Repository
public interface ColumnMapper {
    /**
     * 查询这个表的所有列信息
     *
     * @param tableName 不含schema的表名
     * @return  表的所有列信息
     */
    List<Column> queryColumns(String tableName);
}
