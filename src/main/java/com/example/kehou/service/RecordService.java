package com.example.kehou.service;

import com.example.kehou.domain.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface RecordService extends IService<Record> {

    // 根据userid查所有
    List<Record> getRecordListByUserid(String userId);
}
