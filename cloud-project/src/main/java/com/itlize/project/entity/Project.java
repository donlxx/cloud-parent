package com.itlize.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name="project")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @Column(name="ProjectCode")
    private int projectCode;

    @Column(name="projectName")
    private String projectName;
    
    @CreatedDate
    @Column(name="CreatedDate")
    private Date createdDate;
    

    
}