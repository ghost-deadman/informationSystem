package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.dto.ProjectBudgetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProjectBudgetMapperTest {
    @Autowired
    private ProjectBudgetMapper projectBudgetMapper;

    @Test
    public void testSelect() {
        Page<ProjectBudgetDTO> iPage = new Page<ProjectBudgetDTO>(1, 2);
        Integer[] status = new Integer[]{
                1,2,3
        };
        Page<ProjectBudgetDTO> page = projectBudgetMapper.getPageByUserId(iPage, "1", status);
        if (page != null) {
            List<ProjectBudgetDTO> records = page.getRecords();
            if (records != null) {
                for (ProjectBudgetDTO record : records) {
                    System.out.println(record);
                }
            }
            System.out.println("null");
        }
        System.out.println("null1");
    }

}
