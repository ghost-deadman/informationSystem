package com.example.informationSystem.service;

import com.example.informationSystem.entity.Subject;

import java.util.List;


/**
  * @author pcdn
  */
 public interface SubjectService {

     /**
      * 添加学科数据
      * @param subject 学科对象
      * @return 是否成功
      */
     boolean addSubject(Subject subject);

     /**
      * 删除学科数据
      * @param id 学科id
      * @return 是否成功
      */
     boolean deleteSubject(String id);

     /**
      * 更新学科数据
      * @param subject 学科对象
      * @return 是否成功
      */
     boolean updateSubject(Subject subject);

     /**
      * 查询学科数据
      * @param id id
      * @return 学科数据
      */
     Subject selectSubjectById(String id);

    /**
     * 查询所有学科数据
     * @return 学科数组数据
     */
    List<Subject> selectAll();

 }
