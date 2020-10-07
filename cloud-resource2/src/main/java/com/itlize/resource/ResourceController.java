package com.itlize.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.resource.entity.Project;
import com.itlize.resource.entity.ProjectVO;

@RestController
@RequestMapping("/resource")
public class ResourceController {
//	@Autowired
//    private RestTemplate restTemplate;
//	
//	@Autowired
//	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private ProjectClient projectClient;
	
	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

	
	@GetMapping("/project/{id}")
    public ProjectVO getProjectById(@PathVariable int id){
		//1
//      RestTemplate restTemplate2 = new RestTemplate();
//      Project response = restTemplate2.getForObject("http://localhost:8762/project/{id}", Project.class,id);
		
		//2
//		RestTemplate restTemplate = new RestTemplate();
//		ServiceInstance serviceInstance = loadBalancerClient.choose("CLIENT-PROJECT");
//		String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/project"+"/"+Integer.toString(id);
//		Project response = restTemplate.getForObject(url, Project.class);	
//        return response;
		ProjectVO response =projectClient.findProjectById(id);
		return response;
		
    }
	
	@GetMapping("/project")
	public List<ProjectVO> getProjects(){
		return projectClient.findProjects();
	}
	
	@PostMapping("/project")
	public ResponseEntity createProject(@RequestBody Project project) {
		
		try {
			ResponseEntity response= projectClient.createProject(project);
			if(response.getStatusCode().is2xxSuccessful())return new ResponseEntity<>(HttpStatus.OK);
			else return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}catch(Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/project")
	public ResponseEntity editProject(@RequestBody Project project) {
		try {
			ResponseEntity response= projectClient.editProject(project);
//			System.out.println("start");
//			System.out.println(response);
//			System.out.println("end");
			if(response.getStatusCode().is2xxSuccessful())return new ResponseEntity<>(HttpStatus.OK);
			else return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}catch(Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
//		if(response.getStatusCode().is2xxSuccessful()) return new ResponseEntity(HttpStatus.OK);
//		else return response;
	}
	
	@DeleteMapping("/project/{id}")
	public ResponseEntity deleteProject(@PathVariable int id) {
		try {
			ResponseEntity response= projectClient.deleteProject(id);
			if(response.getStatusCode().is2xxSuccessful()) return new ResponseEntity<>(HttpStatus.OK);
			else return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		catch(Exception e) {
			logger.error(e.toString());
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/msg")
	public String msgTest() {
//		1
//		RestTemplate restTemplate = new RestTemplate();
//		ServiceInstance serviceInstance = loadBalancerClient.choose("CLIENT-PROJECT");
//		String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//		String response = restTemplate.getForObject(url, String.class);
//		logger.info("the URL is: {}",url);
//		logger.info("response={}", response);
		//2
		String response=projectClient.projectMsg();
		return response;
	}
	
}