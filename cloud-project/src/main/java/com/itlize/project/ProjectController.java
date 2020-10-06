package com.itlize.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.project.entity.Project;
import com.itlize.project.entity.ProjectVO;

@RestController
public class ProjectController {
	@Autowired
    private ProjectService service;
	@GetMapping("/project")
    public List<ProjectVO> getProjects(){
		List<ProjectVO> projectVOs=new ArrayList();
		List<Project> projects = service.getProjects();
		for(Project p: projects) {
			ProjectVO vo=new ProjectVO();
			vo.setProjectCode(p.getProjectCode());
			vo.setProjectName(p.getProjectName());
			projectVOs.add(vo);
		}
		return projectVOs;
        //return service.getProjects();
    }
	@GetMapping("/project/{id}")
    public ProjectVO findProjectById(@PathVariable int id){
		ProjectVO vo=new ProjectVO();
		Project p=service.getProjectById(id);
		vo.setProjectCode(p.getProjectCode());
		vo.setProjectName(p.getProjectName());
        return vo;
    }
	@PostMapping("/project")
	public ResponseEntity createProject(@RequestBody Project project) {
		 service.save(project);
		 return new ResponseEntity<>(project,HttpStatus.OK);
	}
	
	@PutMapping("/project")
	public ResponseEntity editProject(@RequestBody Project project) {
		return  service.edit(project);
		 //return new ResponseEntity<>(project,HttpStatus.OK);
	}
	
	@DeleteMapping("/project/{id}")
	public ResponseEntity deleteProject(@PathVariable int id) {
		 return service.delete(id);
		// return new ResponseEntity<>("deleting id is: "+id,HttpStatus.OK);
	}
	@GetMapping("/msg")
	public String msgTest() {
		return "msg test works";
	}

}
