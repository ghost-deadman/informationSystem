package com.example.informationSystem.entity.DTO;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
public class ArrangePlanDTO implements Serializable {

    private String arrangePlanId;

    private String title;

    private String money;

    private String describes;

    private String projectId;

    private LocalDate date;

}
