package com.example.informationSystem.entity.VO;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

/**
 *  资金使用记录日志vo
 */
@Data
@ToString
public class ArrangePlanVO implements Serializable {

    private String projectId;

    private String title;

    private String money;

    private Date date;

    private String describes;

}
