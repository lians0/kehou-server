package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Record;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Date;

/**
 * @author ShuangLian
 * @date 2021/12/20 19:59
 */
@SpringBootTest
class RecordMapperTest {

    @Resource
    private RecordMapper recordMapper;


    @Test
    void insertOne() {
        Record record = new Record();
//        record.setCreateTime(new Date());
//        recordMapper.insertOne(record);

        recordMapper.insert(record);
    }
}