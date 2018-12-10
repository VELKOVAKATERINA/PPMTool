package com.springproject.ppmtool.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.ppmtool.domain.Project;
import com.springproject.ppmtool.exceptions.ProjectIdentifierException;
import com.springproject.ppmtool.services.ProjectService;
import com.springproject.ppmtool.services.ValidationService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	private final ProjectService projectService;
	private final ValidationService validationService;

	public ProjectController(ProjectService projectService,ValidationService validationService) {
		this.projectService = projectService;
		this.validationService=validationService;
	}
	@PostMapping("") //BindingResult object so you can test for and retrieve validation errors
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result){
		
		ResponseEntity<HashMap<String, String>> errors=validationService.getMapErrors(result);
		if(errors!=null) return errors;
		
		Project projectNew=projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	@GetMapping("/all")//List of JSON objects
	public Iterable<Project> findAllProject(){
		return projectService.findAllProject();
	}
	@GetMapping("/{projectId}")
	public ResponseEntity<?> findProjectById(@PathVariable String projectId){
		Project project=projectService.findProjectByIdentifier(projectId);
		if(project==null) {
			throw new ProjectIdentifierException("Project with identifier "+projectId+" doesn't found");
		}
		return new ResponseEntity<Project>(project,HttpStatus.OK);
		
	}
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProjectById(@PathVariable String projectId){
		projectService.deleteProjectById(projectId);
		
		return new ResponseEntity<String>("The project with ID "+projectId+" was deleted",HttpStatus.OK);
	}

}
