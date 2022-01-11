package com.example.kehou.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Test
    void selectOne() {

        QueryWrapper<Record> recordQueryWrapper = new QueryWrapper<>();
        recordQueryWrapper.eq("record_id","10");
        Record record = recordMapper.selectOne(recordQueryWrapper);
        System.out.println(record);
    }
    @Test
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        int[] arr  = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int i1 = Character.hashCode(c);
            arr[i1]++;

            char c1 = t.charAt(i);
            int i2 = Character.hashCode(c1);
            arr[i2]--;
        }
        for (int i : arr) {
            if (i!=0) {
                return false;
            }
        }

        return true;

    }
}