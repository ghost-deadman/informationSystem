package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.informationSystem.entity.ProjectSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProjectSubjectMapper extends BaseMapper<ProjectSubject> {
    @Select("select count(*) from project_subject ps ,subject s where s.name = #{name} and ps.subject_id = s.subject_id")
    Integer selectProjectSubjectCount(String name);
}
