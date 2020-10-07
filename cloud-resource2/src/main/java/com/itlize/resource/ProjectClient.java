package com.itlize.resource;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itlize.resource.entity.Project;
import com.itlize.resource.entity.ProjectVO;

import feign.Headers;

@FeignClient(name="CLIENT-PROJECT")
@Headers({"Content-type", "application/json"})
public interface ProjectClient {
	@GetMapping(value="/msg")
	String projectMsg();
	
	@GetMapping(value= "/project/{id}")
	public ProjectVO findProjectById(@PathVariable(value = "id") int id);
	
	@GetMapping("/project")
    public List<ProjectVO> findProjects();
	
	@PostMapping("/project")
	public ResponseEntity createProject(@RequestBody Project project);
	
	@PutMapping("/project")
	public ResponseEntity editProject(@RequestBody Project project);
	
	@DeleteMapping(value="/project/{id}")
	public ResponseEntity deleteProject(@PathVariable(value = "id") int id);
}