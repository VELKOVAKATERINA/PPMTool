package com.springproject.ppmtool.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.springproject.ppmtool.domain.Project;
import com.springproject.ppmtool.exceptions.ProjectIdentifierException;
import com.springproject.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	private final ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}


	@Override
	public Project saveOrUpdate(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}catch(Exception e) {
			throw new ProjectIdentifierException("Project identifier "+project.getProjectIdentifier().toUpperCase()+" already exists");
		}
	}


	@Override
	public Project findProjectByIdentifier(String projectId) {
		Project project=projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		return project;
	}


	@Override//List of JSON objects
	public Iterable<Project> findAllProject() {
		return projectRepository.findAll();
	}


	@Override
	public void deleteProjectById(String projectId) {
		Project project=findProjectByIdentifier(projectId.toUpperCase());
		if(project==null) {
			throw new ProjectIdentifierException("Cannot delete the project with ID '"+projectId+"' .It doesn't exists.");
		}
		projectRepository.delete(project);
	}

}
