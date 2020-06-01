package com.wangjie.generator.service.dto;

import com.wangjie.generator.model.db.Column;

import java.util.List;

/**
 * @ClassName TableDTO
 * @Description 数据库表的所有信息
 * @Author wangjie
 * @Date 2020/5/29 4:37 下午
 * @Email wangjie_fourth@163.com
 **/
public class TableDTO {

    private String tableName;

    private String primaryKey;

    private String tableNote;

    private List<Column> columnList;

}
