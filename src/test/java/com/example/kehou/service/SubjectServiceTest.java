package com.example.kehou.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ShuangLian
 * @date 2022/1/17 17:08
 */
@SpringBootTest
class SubjectServiceTest {
    @Resource SubjectService subjectService;

    @Test
    void getSubjectBySubjectId() {
        System.out.println(subjectService.getSubjectBySubjectId("1"));
    }

    @Test
    void getSubjectDetailBySubjectId() {

    }

    @Test
    void searchSubject() {
    }
}