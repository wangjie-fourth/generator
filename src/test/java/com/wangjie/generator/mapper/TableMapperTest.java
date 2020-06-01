package com.wangjie.generator.mapper;

import com.wangjie.generator.model.db.Table;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableMapperTest {

    @Autowired
    private TableMapper tableMapper;

    @Test
    void queryTable() {
        Table table_info = tableMapper.queryTable("table_info");
        System.out.println("table_info = " + table_info);
    }
}