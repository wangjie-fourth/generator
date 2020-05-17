package com.wangjie.generator.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseInfoMapperTest {
    private static final String TABLE_NAME = "table_info";
    @Autowired
    private DataBaseInfoMapper dataBaseInfoMapper;

    @Test
    public void queryTable() {
        Map<String, String> tableInfo = dataBaseInfoMapper.queryTable(TABLE_NAME);
        System.out.println("tableInfo = " + tableInfo);
    }

    @Test
    public void queryColumns() {
        List<Map<String, String>> columns = dataBaseInfoMapper.queryColumns(TABLE_NAME);
        System.out.println("columns = " + columns);
    }

    @Test
    public void queryTableList(){
        List<Map<String, Object>> tables = dataBaseInfoMapper.queryTableList(null);
        tables.forEach(System.out::println);
    }
}
