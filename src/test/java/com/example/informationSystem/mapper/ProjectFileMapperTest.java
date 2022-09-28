package com.example.informationSystem.mapper;

import com.example.informationSystem.entity.ProjectFile;
import com.example.informationSystem.service.ProjectFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/21 9:07
 */
@SpringBootTest
public class ProjectFileMapperTest {

    @Autowired
    private ProjectFileMapper projectFileMapper;

   @Test
    public void selectProjectFileIdByProjectDraftIdTest(){

       List<String> projectFileIdList = projectFileMapper.selectProjectFileIdByProjectDraftId("f311b8e7-eb66-4628-8664-715d651c3472");


   }


}
