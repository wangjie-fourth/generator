package com.wangjie.generator.mapper;

import com.wangjie.generator.model.db.Column;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColumnMapperTest {
    @Autowired
    private ColumnMapper columnMapper;

    @Test
    public void test(){
        List<Column> table_info = columnMapper.queryColumns("table_info");
        table_info.forEach(System.out::println);
    }

}