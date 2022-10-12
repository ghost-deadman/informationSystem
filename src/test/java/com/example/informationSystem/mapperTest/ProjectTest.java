package com.example.informationSystem.mapperTest;

import com.example.informationSystem.entity.DTO.ProjectDTO;
import com.example.informationSystem.mapper.ProjectMapper;
import com.example.informationSystem.service.ProjectService;
import com.example.informationSystem.utils.Pager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProjectTest {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectService projectService;

    @Test
    public void testSelect() {
        List<ProjectDTO> projectDTOS = projectMapper.selectProjectByCreateStatusAndUserPage(0, "123456", 0L, 8L);
        for (ProjectDTO projectDTO : projectDTOS) {
            System.out.println(projectDTO.getProjectName());
        }
    }

    @Test
    public void testSelectOne(){
        System.out.println(projectService.selectProjectDtoByProjectId("e3e3ee3f-a26d-4b52-af90-d8c84c74f9a7"));
    }

    @Test
    public void testSubject() {
        projectService.selectProjectDtoByUserIdAndCreateStatus(0, "123456", 0L, 8L);
    }
    @Test
    public void testSubject2() {
        Pager<ProjectDTO> projectDTOPager = projectService.selectProjectDtoByUserIdAndCreateStatus(0, "123456", 0L, 8L);
        List<ProjectDTO> dataList = projectDTOPager.getDataList();
        for (ProjectDTO projectDTO : dataList) {
            System.out.println(projectDTO.getSubjectList());
        }
    }

}
