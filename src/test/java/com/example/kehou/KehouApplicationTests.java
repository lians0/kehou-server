package com.example.kehou;

import com.alibaba.fastjson.JSON;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.vo.SearchResultVO;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spring.web.json.Json;

@SpringBootTest
class KehouApplicationTests {

    @Test
    void contextLoads() {
        Course course = JSON.parseObject("{}", Course.class);
        System.out.println(BeanUtils.isNull(course));
    }


}
