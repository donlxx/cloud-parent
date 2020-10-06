package com.itlize.project;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.itlize.project.entity.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<Project> getProjects(){
		return projectRepository.findAll();
	}
	public Project getProjectById(int id) {
		return projectRepository.findById(id).get();
	}
	public ResponseEntity save(Project p) {
		projectRepository.save(p);
//		return new Response(true);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	public ResponseEntity edit(Project p) {
		try{
			Project project = projectRepository.findById(p.getProjectCode()).get();
			project.setProjectCode(p.getProjectCode());
			project.setProjectName(p.getProjectName());
			projectRepository.save(project);
//			return new Response(true);
			return new ResponseEntity<>(project,HttpStatus.OK);
			
		}
		catch(Exception e){
			System.out.println(e);
			logger.error(e.toString());
			return new ResponseEntity<>(p,HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	
	public ResponseEntity delete(int id) {
		try {
			projectRepository.deleteById(id);
			return new ResponseEntity<>("deleting id is"+id,HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>("the product id is not existing",HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}
