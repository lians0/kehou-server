package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.service.RecordService;
import com.example.kehou.domain.entity.Record;
import com.example.kehou.mapper.RecordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
    implements RecordService {

    @Override
    public List<Record> getRecordListByUserid(String userId) {
        List<Record> recordList = baseMapper
                .selectList(new QueryWrapper<Record>().eq("user_id", userId));
        return recordList;
    }
}




