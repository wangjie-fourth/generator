package com.wangjie.generator.service.impl;

import com.google.common.base.CaseFormat;
import com.wangjie.generator.controller.vo.GeneratorVo;
import com.wangjie.generator.mapper.ColumnMapper;
import com.wangjie.generator.mapper.TableMapper;
import com.wangjie.generator.model.db.Column;
import com.wangjie.generator.service.ProjectGeneratorService;
import com.wangjie.generator.service.dto.AttrDTO;
import com.wangjie.generator.service.dto.JavaDTO;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * @ClassName DeYiProjectGeneratorServiceImpl
 * @Description
 * @Author wangjie
 * @Date 2020/5/18 5:02 下午
 * @Email wangjie_fourth@163.com
 **/
@Service
public class DeYiProjectGeneratorServiceImpl implements ProjectGeneratorService {

    @Autowired
    private TableMapper tableMapper;

    @Autowired
    private ColumnMapper columnMapper;

    private static final VelocityContext context;

    @Override
    public String generatorManager(JavaDTO javaDTO) throws IOException {
        context.put("java", javaDTO);
        return generatorModel(context, "template/deyi/Manager.java.vm");
    }

    @Override
    public String generatorDTO(JavaDTO javaDTO) throws IOException {
        context.put("java", javaDTO);
        return generatorModel(context, "template/deyi/DTO.java.vm");
    }


    @Override
    public String generatorMapperJava(JavaDTO javaDTO) throws IOException {
        // 生成属性
        setAttrs(javaDTO);
        context.put("java", javaDTO);
        return generatorModel(context, "template/deyi/Mapper.java.vm");
    }

    @Override
    public String generatorMapperXml(JavaDTO javaDTO) throws IOException {
        // 生成属性
        setAttrs(javaDTO);
        context.put("java", javaDTO);
        return generatorModel(context, "template/deyi/Mapper.xml.vm");
    }

    @Override
    public String generatorEntity(JavaDTO javaDTO) throws IOException {
        // 生成属性
        setAttrs(javaDTO);
        context.put("java", javaDTO);
        return generatorModel(context, "template/deyi/Bean.java.vm");
    }

    private void setAttrs(JavaDTO javaDTO) {
        List<Column> result = columnMapper.queryColumns(javaDTO.getTableName());
        // 设置attrs
        List<AttrDTO> attrsMapList = new ArrayList<>();
        // 列表模型 转 实体模型
        for (Column column : result) {
            AttrDTO attr = new AttrDTO();
            // 数据类型转换
            switch (column.getDataType()) {
                case "bigint":
                    attr.setAttrType("Long");
                    attr.setJdbcType("BIGINT");
                    break;
                case "int":
                case "tinyint":
                    attr.setAttrType("Integer");
                    attr.setJdbcType("INTEGER");
                    break;
                case "timestamp":
                case "date":
                    attr.setAttrType("Date");
                    attr.setJdbcType("DATE");
                    break;
                case "varchar":
                    attr.setAttrType("String");
                    attr.setJdbcType("VARCHAR");
                    break;
            }
            // 列名转属性名
            String attrName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column.getColumnName());
            attr.setAttrName(attrName);
            attr.setAttrNote(column.getColumnComment());
            attr.setColumnName(column.getColumnName());

            // 判断是否为主键
            attr.setPK(column.getColumnName().equals("id"));
            attrsMapList.add(attr);
        }
    }

    static {
        // 模版引擎
        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(p);
        context = new VelocityContext();
    }


    @Override
    public String generatorController(JavaDTO javaDTO) throws IOException {
        context.put("java", javaDTO);
        return generatorModel(context, "template/deyi/Controller.java.vm");
    }

    @Override
    public String generatorService(JavaDTO javaDTO) throws IOException {
        context.put("java", javaDTO);
        return generatorModel(context, "template/deyi/Service.java.vm");
    }


    private String generatorModel(VelocityContext context, String templateVm) throws IOException {
        // 生成模板
        Template template = null;
        try {
            template = Velocity.getTemplate(templateVm, "UTF-8");
        } catch (ResourceNotFoundException rnfe) {
            // couldn't find the template
            throw new RuntimeException(rnfe);
        } catch (ParseErrorException pee) {
            // syntax error: problem parsing the template
            throw new RuntimeException(pee);

        } catch (MethodInvocationException mie) {
            // something invoked in the template

            // threw an exception
            throw new RuntimeException(mie);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        System.out.println("================================");
        System.out.println(sw);
        return sw.toString();
    }


}
