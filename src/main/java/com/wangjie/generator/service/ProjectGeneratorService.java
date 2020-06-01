package com.wangjie.generator.service;

import com.wangjie.generator.controller.vo.GeneratorVo;
import com.wangjie.generator.service.dto.JavaDTO;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName ProjectGeneratorService
 * @Description
 * @Author wangjie
 * @Date 2020/5/18 5:01 下午
 * @Email wangjie_fourth@163.com
 **/

public interface ProjectGeneratorService {

    String generatorController(JavaDTO javaDTO) throws IOException;

    String generatorService(JavaDTO javaDTO) throws IOException;

    String generatorEntity(JavaDTO javaDTO) throws IOException;

    String generatorMapperJava(JavaDTO javaDTO) throws IOException;

    String generatorMapperXml(JavaDTO javaDTO) throws IOException;

    String generatorManager(JavaDTO javaDTO) throws IOException;

    String generatorDTO(JavaDTO generatorVo) throws IOException;
}
