package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Chapter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ShuangLian
 * @date 2021/12/16 9:49
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
class ChapterMapperTest {
    @Resource
    private ChapterMapper chapterMapper;

    @Test
    void getChapterByChapterId() {
    }

    @Test
    void getChapterListByChapterId() {
        List<Chapter> chapterListByChapterId = chapterMapper.getChapterListByChapterId("100");
        System.out.println(chapterListByChapterId.size()==0);
    }

    @Test
    void countBySubjectId() {
        System.out.println(chapterMapper.countBySubjectId("1"));
    }
}