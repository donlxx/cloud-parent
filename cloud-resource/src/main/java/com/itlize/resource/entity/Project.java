package com.itlize.resource.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Table(name="project")
@Data
public class Project {

    @Id
    @Column(name="ProjectCode")
    private int projectCode;

    @Column(name="projectName")
    private String projectName;

//    @CreatedDate
    @Column(name="CreatedDate")
    private Date createdDate;

    
}