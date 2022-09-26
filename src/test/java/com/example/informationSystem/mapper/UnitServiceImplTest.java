package com.example.informationSystem.mapper;

import com.example.informationSystem.entity.Unit;
import com.example.informationSystem.service.impl.UnitServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/14 9:26
 */
@SpringBootTest
public class UnitServiceImplTest {

    @Autowired
    private UnitServiceImpl unitService;

    @Test
    public void addUnitTest(){

        Unit unit = new Unit();

        unit.setUnitId(UUID.randomUUID().toString());

        unit.setName("1号");

        unitService.addUnit(unit);

    }

    @Test
    public void deleteUnitTest(){

        unitService.deleteUnit("5bfa563e-70f5-4f27-a889-262cf70d842c");

    }

    @Test
    public void updateUnitTest(){

        Unit unit = new Unit();

        unit.setUnitId("5bfa563e-70f5-4f27-a889-262cf70d842c");

        unit.setName("2号");

        unitService.updateUnit(unit);

    }

    @Test
    public void selectUnitTest(){

        Unit unit = unitService.selectUnit("5bfa563e-70f5-4f27-a889-262cf70d842c");

        System.out.println(unit);

    }

}
