package com.example.informationSystem.service;

import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.service.impl.SubjectServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)//启动项目
@SpringBootTest//加载spring容器
public class SubjectServiceTest {
    @Autowired
    private SubjectServiceImpl subjectService;

    @Test
    public void addSubjectTest(){

        Subject subject = new Subject();

        subject.setSubjectId(UUID.randomUUID().toString());

        subject.setName("1号");

        subjectService.addSubject(subject);

    }

    @Test
    public void deleteUnitTest(){

        subjectService.deleteSubject("6a02069e-f382-41d0-bbe8-939cf66f06fa");

    }

    @Test
    public void updateUnitTest(){

        Subject subject = new Subject();

        subject.setSubjectId("b0d687b2-74ba-4d56-a37d-2ca714b159cb");

        subject.setName("2号");

        subjectService.updateSubject(subject);


    }

    @Test
    public void selectUnitTest(){

        Subject subject = subjectService.selectSubject("b0d687b2-74ba-4d56-a37d-2ca714b159cb");

        System.out.println(subject);

    }



}
