package com.example.informationSystem.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author pcdn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectBudgetVO implements Serializable {

    private String projectId;

    private String money;

    private String describes;

}
