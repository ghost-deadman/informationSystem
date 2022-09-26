package com.example.informationSystem.service.impl;

import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.mapper.SubjectMapper;
import com.example.informationSystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    public boolean addSubject(Subject subject){

        subjectMapper.insert(subject);

        return true;

    }

    public boolean deleteSubject(String id){

        subjectMapper.deleteById(id);

        return true;

    }

    public boolean updateSubject(Subject subject){

        subjectMapper.updateById(subject);

        return true;

    }

    public Subject selectSubject(String id){

        return subjectMapper.selectById(id);

    }
}
