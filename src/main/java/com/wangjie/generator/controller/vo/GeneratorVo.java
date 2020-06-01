package com.wangjie.generator.controller.vo;

import lombok.*;


/**
 * @ClassName GeneratorVo
 * @Description 
 * @Author wangjie
 * @Date 2020/5/29 2:33 下午
 * @Email wangjie_fourth@163.com
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratorVo {
    private String tableName;

    private String tableNote;

    private String tablePrefix;

    private String packagePrefix;

    private String author;

    private String email;

}
