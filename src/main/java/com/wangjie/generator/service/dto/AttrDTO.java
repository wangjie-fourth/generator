package com.wangjie.generator.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName AttrDTO
 * @Description 
 * @Author wangjie
 * @Date 2020/6/1 11:44 上午
 * @Email wangjie_fourth@163.com
 **/
@Getter
@Setter
public class AttrDTO {

    private String attrName;
    private String attrType;
    private String attrNote;


    private boolean isPK;
    private String jdbcType;
    private String columnName;
}
