package com.example.informationSystem.service;

import com.example.informationSystem.entity.Unit;


public interface UnitService {

     boolean addUnit(Unit unit);

     boolean deleteUnit(String id);

     boolean updateUnit(Unit unit);

     Unit selectUnit(String id);
}
