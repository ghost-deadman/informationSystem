package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.Unit;
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
public class UnitServiceTest {

    @Autowired
    private UnitService unitService;

    @Test
    public void test(){

        System.out.println();

    }

    @Test
    public void addUnitTest(){

        Unit unit = new Unit();

        unit.setUnitId(UUID.randomUUID().toString());

        unit.setName("1号");

        unitService.addUnit(unit);

    }

    @Test
    public void deleteUnitTest(){

        unitService.deleteUnit("68580b1b-5f05-4962-a770-911f1cbdc9c2");

    }

    @Test
    public void updateUnitTest(){

        Unit unit = new Unit();

        unit.setUnitId("68580b1b-5f05-4962-a770-911f1cbdc9c2");

        unit.setName("2号");

        unitService.updateUnit(unit);

    }

    @Test
    public void selectUnitTest(){

        Unit unit = unitService.selectUnit("68580b1b-5f05-4962-a770-911f1cbdc9c2");

        System.out.println(unit);

    }

    @Test
    public void selectAllTest(){

        List<Unit> unitList = unitService.selectAll();

        System.out.println(unitList);

    }

    @Test
    public void selectPage(){

        IPage<Unit> page = unitService.selectPage(1);

        System.out.println("第几页" + page.getCurrent());

        System.out.println("每页大小" + page.getSize());

        System.out.println("总页数" + page.getPages());

        System.out.println("数据数" + page.getTotal());

        System.out.println("数据" + page.getRecords());


    }

}
