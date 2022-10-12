package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.ProjectSubject;
import com.example.informationSystem.entity.VO.ProjectSubjectVO;
import com.example.informationSystem.mapper.ProjectSubjectMapper;
import com.example.informationSystem.service.ProjectSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectSubjectServiceImpl implements ProjectSubjectService {
    @Autowired
    private ProjectSubjectMapper projectSubjectMapper;
    @Override
    public boolean addProjectSubject(ProjectSubject projectSubject) {
        projectSubjectMapper.insert(projectSubject);
        return true;
    }

    @Override
    public boolean deleteProjectSubject(String id) {
        projectSubjectMapper.deleteById(id);
        return true;
    }

    @Override
    public boolean updateProjectSubject(ProjectSubject projectSubject) {
        projectSubjectMapper.updateById(projectSubject);
        return false;
    }

    @Override
    public ProjectSubject selectProjectSubjectById(String id) {
        projectSubjectMapper.selectById(id);
        return null;
    }

    @Override
    public List<ProjectSubject> selectProjectSubject() {
        return projectSubjectMapper.selectList(null);
    }

    @Override
    public List<ProjectSubjectVO> subjectDataAnalysis() {
         /*
        学科数据分析，归纳每个学科出现的总次数然后返回subjectVO对象列表
         */
        String [] strings = {"计算机","美术","数学","英语","语文","物理","化学","生物","音乐","土木"};

        List<ProjectSubjectVO> subjectVOList = new ArrayList<>();
        for (String s:strings) {
            int count = projectSubjectMapper.selectProjectSubjectCount(s);
            if(count == 0){
                continue;
            }
            subjectVOList.add(new ProjectSubjectVO(s,count));
        }

        return subjectVOList;

    }
}
