package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.ProjectBudgetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/30 15:09
 */
@SpringBootTest
public class ProjectBudgetMapperTest {

    @Autowired
    private ProjectBudgetMapper projectBudgetMapper;

    @Test
    public void testSelect() {
        String id = "123456";
        Page<ProjectBudgetDTO> iPage = new Page<>(1, 5);
        Page<ProjectBudgetDTO> pageByUserId = projectBudgetMapper.getPageByUserId(iPage, id, 2);
        List<ProjectBudgetDTO> records = pageByUserId.getRecords();
        for (ProjectBudgetDTO record : records) {
            System.out.println(record);
        }
    }

    @Test
    public void testDelete() {
        boolean b = projectBudgetMapper.deleteProjectBudget();
        System.out.println(b);
    }
}
