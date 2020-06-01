package com.wangjie.generator.controller;

import com.google.common.base.CaseFormat;
import com.wangjie.generator.controller.vo.GeneratorVo;
import com.wangjie.generator.controller.vo.TableVO;
import com.wangjie.generator.mapper.TableMapper;
import com.wangjie.generator.model.db.Table;
import com.wangjie.generator.service.ProjectGeneratorService;
import com.wangjie.generator.service.dto.JavaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName DeYiController
 * @Description
 * @Author wangjie
 * @Date 2020/5/17 4:16 下午
 * @Email wangjie_fourth@163.com
 **/

@RestController
@RequestMapping("/deyi")
public class DeYiController {

    @Autowired
    private TableMapper tableMapper;

    @Autowired
    private ProjectGeneratorService projectGeneratorService;

    private static JavaDTO from(GeneratorVo generatorVo){
        String paramClass = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,generatorVo.getTableName());
        String className = Character.toUpperCase(paramClass.charAt(0)) + paramClass.substring(1);

        JavaDTO javaDTO = JavaDTO.builder()
                .paramName(paramClass)
                .className(className)
                .note(generatorVo.getTableNote())
                .author(generatorVo.getAuthor())
                .email(generatorVo.getEmail())
                .dateTime(new Date())
                .packagePrefix(generatorVo.getPackagePrefix())
                .tableName(generatorVo.getTableName())
                .build();
        return javaDTO;
    }

    @PostMapping("/dto")
    public ResponseEntity<?> dto(@RequestBody GeneratorVo generatorVo) throws IOException, InvocationTargetException, IllegalAccessException {
        String controller = projectGeneratorService.generatorDTO(DeYiController.from(generatorVo));
        return ResponseEntity.ok(controller);
    }
    @PostMapping("/controller")
    public ResponseEntity<?> controller(@RequestBody GeneratorVo generatorVo) throws IOException {
        String controller = projectGeneratorService.generatorController(DeYiController.from(generatorVo));
        return ResponseEntity.ok(controller);
    }

    @PostMapping("/manager")
    public ResponseEntity<?> manager(@RequestBody GeneratorVo generatorVo) throws IOException {
        String controller = projectGeneratorService.generatorManager(DeYiController.from(generatorVo));
        return ResponseEntity.ok(controller);
    }

    @PostMapping("/service")
    public ResponseEntity<?> service(@RequestBody GeneratorVo generatorVo) throws IOException {
        String string = projectGeneratorService.generatorService(DeYiController.from(generatorVo));
        return ResponseEntity.ok(string);
    }

    @PostMapping("/entity")
    public ResponseEntity<?> entity(@RequestBody GeneratorVo generatorVo) throws IOException {
        String string = projectGeneratorService.generatorEntity(DeYiController.from(generatorVo));
        return ResponseEntity.ok(string);
    }

    @PostMapping("/mapper-java")
    public ResponseEntity<?> mapperJava(@RequestBody GeneratorVo generatorVo) throws IOException {
        String string = projectGeneratorService.generatorMapperJava(DeYiController.from(generatorVo));
        return ResponseEntity.ok(string);
    }

    @PostMapping("/mapper-xml")
    public ResponseEntity<?> mapperXml(@RequestBody GeneratorVo generatorVo) throws IOException {
        String string = projectGeneratorService.generatorMapperXml(DeYiController.from(generatorVo));
        return ResponseEntity.ok(string);
    }

    /**
     * 查询数据库的表信息
     *
     * @param params    参数信息
     * @return  返回值
     */
    @RequestMapping("/list")
    public ResponseEntity<?> list(@RequestParam Map<String, Object> params) {
        List<Table> result = tableMapper.queryTableList(null);
        return ResponseEntity.ok(result.stream().map(TableVO::from).collect(Collectors.toList()));
    }

    /**
     * MVC模型生成代码
     *
     * @param request   request
     * @param response  response
     * @throws IOException IO异常
     */
    @RequestMapping("/mvc/code")
    public void codeByMVC(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        projectGeneratorService.generatorProject();
    }
}
