package com.wangjie.generator.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipOutputStream;

@SpringBootTest
public class DeYiProjectGeneratorServiceImplTest {

    @Autowired
    private DeYiProjectGeneratorServiceImpl deYiProjectGeneratorService;

    @Test
    void generatorProject() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
//        deYiProjectGeneratorService.generatorProject("table_info",new HashMap<>(),zip);

    }
}
