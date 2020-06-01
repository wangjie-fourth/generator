package com.wangjie.generator.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseInfoMapperTest {
    private static final String TABLE_NAME = "table_info";
    @Autowired
    private DataBaseInfoMapper dataBaseInfoMapper;


}
