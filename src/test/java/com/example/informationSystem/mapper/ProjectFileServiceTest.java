package com.example.informationSystem.mapper;

import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.service.ProjectFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 9:07
 */
@SpringBootTest
public class ProjectFileServiceTest {

    @Autowired
    private ProjectFileService projectFileService;

    @Test
    public void addProjectFileTest(){

        ProjectFile projectFile = new ProjectFile();

        projectFile.setProjectId(UUID.randomUUID().toString());

        projectFile.setProjectDraftId(UUID.randomUUID().toString());

        projectFile.setType(0);

        projectFile.setProjectFileId(UUID.randomUUID().toString());

        projectFile.setDate(LocalDateTime.now());

        projectFile.setName(UUID.randomUUID().toString());

        projectFile.setPath("path");

        projectFileService.addProjectFile(projectFile);

    }


}
