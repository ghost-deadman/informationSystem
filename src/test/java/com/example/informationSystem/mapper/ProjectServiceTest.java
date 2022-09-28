package com.example.informationSystem.mapper;

import com.example.informationSystem.entity.DTO.ProjectDTO;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/15 9:48
 */
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    ProjectService projectService;

    @Test
    public void test1(){

        List<ProjectDTO> projectList =  projectMapper.selectProjectByCreateStatusAndUserPage(0,"123456", 0, 5L);

    }

    @Test
    public void test2(){



        projectService.updateProjectCreateStatusById("e3e3ee3f-a26d-4b52-af90-d8c84c74f9a7",1);

    }


}
