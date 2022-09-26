package com.example.informationSystem.service;

import com.example.informationSystem.entity.Subject;


 public interface SubjectService {

     boolean addSubject(Subject subject);

     boolean deleteSubject(String id);

     boolean updateSubject(Subject subject);

     Subject selectSubject(String id);
}
