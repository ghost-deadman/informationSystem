package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.Subject;
import com.example.informationSystem.mapper.SubjectMapper;
import com.example.informationSystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public boolean addSubject(Subject subject){

        subjectMapper.insert(subject);

        return true;

    }

    @Override
    public boolean deleteSubject(String id){

        subjectMapper.deleteById(id);

        return true;

    }

    @Override
    public boolean updateSubject(Subject subject){

        subjectMapper.updateById(subject);

        return true;

    }

    @Override
    public Subject selectSubjectById(String id) {
        return subjectMapper.selectById(id);
    }

    @Override
    public List<Subject> selectAll() {
        return subjectMapper.selectList(null);
    }

}
