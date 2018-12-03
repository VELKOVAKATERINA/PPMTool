package com.springproject.ppmtool.services;

import org.springframework.stereotype.Service;
import com.springproject.ppmtool.domain.Project;
import com.springproject.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	private final ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}


	@Override
	public Project saveOrUpdate(Project project) {
		// Logic
		
		
		return projectRepository.save(project);
	}
	
	

}
