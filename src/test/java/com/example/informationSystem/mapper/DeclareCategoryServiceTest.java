package com.example.informationSystem.mapper;

import com.example.informationSystem.entity.DeclareCategory;
import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.service.DeclareCategoryService;
import com.example.informationSystem.service.UnitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 9:26
 */
@SpringBootTest
public class DeclareCategoryServiceTest {

    @Autowired
    private DeclareCategoryService declareCategoryService;

    @Test
    public void addDeclareCategoryTest(){

        DeclareCategory declareCategory = new DeclareCategory();

        declareCategory.setDeclareCategoryId(UUID.randomUUID().toString());

        declareCategory.setName("1号");

        declareCategoryService.addDeclareCategory(declareCategory);

    }

    @Test
    public void deleteDeclareCategoryTest(){

        declareCategoryService.deleteDeclareCategoryById("68580b1b-5f05-4962-a770-911f1cbdc9c2");

    }

    @Test
    public void updateDeclareCategoryTest(){

        DeclareCategory declareCategory = new DeclareCategory();

        declareCategory.setDeclareCategoryId("68580b1b-5f05-4962-a770-911f1cbdc9c2");

        declareCategory.setName("2号");

        declareCategoryService.updateDeclareCategory(declareCategory);

    }

    @Test
    public void selectUnitTest(){

        DeclareCategory declareCategory = declareCategoryService.selectDeclareCategoryById("68580b1b-5f05-4962-a770-911f1cbdc9c2");

        System.out.println(declareCategory);

    }

    @Test
    public void selectAllTest(){

        List<DeclareCategory> declareCategoryList = declareCategoryService.selectAll();

        System.out.println(declareCategoryList);

    }

}
