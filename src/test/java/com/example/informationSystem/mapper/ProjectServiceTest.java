package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 9:48
 */
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void addProjectTest(){

        Project project = new Project();

        project.setProjectId(UUID.randomUUID().toString());

        project.setProjectUserId(UUID.randomUUID().toString());

        project.setProjectContextId(UUID.randomUUID().toString());

        project.setFinancialProgressId(UUID.randomUUID().toString());

     //   project.setUnitUserId(UUID.randomUUID().toString());

        project.setCreateDate(LocalDateTime.now());

        projectService.addProject(project);

    }

    @Test
    public void selectProjectTest(){

//       Project project = projectService.selectProject("3d57fc5d-b613-444b-bc87-5061ccd41aee");
//
//       System.out.println(project);

    }

}
