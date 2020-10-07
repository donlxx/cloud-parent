package com.itlize.resource;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itlize.resource.entity.Project;
import com.itlize.resource.entity.ProjectVO;

@Component
@FeignClient(name="CLIENT-PROJECT")
//@Headers({"Content-type", "application/json"})
public interface ProjectClient {
	@GetMapping("/msg")
	String projectMsg();
	
	@GetMapping("/project/{id}")
	public ProjectVO findProjectById(@PathVariable int id);
	
	@GetMapping("/project")
    public List<ProjectVO> findProjects();
	
	@PostMapping("/project")
	public ResponseEntity createProject(@RequestBody Project project);
	
	@PutMapping("/project")
	public ResponseEntity editProject(@RequestBody Project project);
	
	@DeleteMapping("/project/{id}")
	public ResponseEntity deleteProject(@PathVariable int id);
}
