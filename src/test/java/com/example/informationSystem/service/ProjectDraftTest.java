package com.example.informationSystem.service;

import com.example.informationSystem.entity.ProjectDraft;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)//启动项目
@SpringBootTest//加载spring容器
public class ProjectDraftTest {
    @Autowired
    private ProjectDraftService projectDraftService;

    @Test
    public void addProjectDraft(){
        ProjectDraft projectDraft = new ProjectDraft();
        projectDraft.setName("喵喵");
        //projectDraft.setCreateDate(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        projectDraftService.addProjectDraft(projectDraft);
    }
}
