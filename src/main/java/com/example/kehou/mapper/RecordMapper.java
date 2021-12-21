package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.domain.Record
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    void insertOne(Record record);

}




