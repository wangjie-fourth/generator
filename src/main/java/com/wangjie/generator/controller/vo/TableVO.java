package com.wangjie.generator.controller.vo;

import com.wangjie.generator.model.db.Table;
import lombok.*;

import java.util.Date;

/**
 * @ClassName TableVO
 * @Description 
 * @Author wangjie
 * @Date 2020/5/29 11:35 上午
 * @Email wangjie_fourth@163.com
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableVO {
    private String tableName;
    private String tableEngine;
    private String tableNote;
    private Date tableCreateTime;

    public static TableVO from(Table table){
        return TableVO.builder()
                .tableName(table.getTableName())
                .tableEngine(table.getEngine())
                .tableNote(table.getTableComment())
                .tableCreateTime(table.getCreateTime())
                .build();
    }
}
