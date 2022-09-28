package com.example.informationSystem.entity.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.informationSystem.entity.Project;
import com.example.informationSystem.entity.ProjectDraft;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/26 14:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectDraftDTO extends ProjectDraft implements Serializable {

    /**
     * 单位名称
     */
    @TableField(value = "name",exist = false)
    private String unitName;

    /**
     * 项目文件id
     */
    private List<String> projectFileIdList;

    /**
     * 项目文件
     */
    @TableField(exist = false)
    private List<String> fileNameList;


}
