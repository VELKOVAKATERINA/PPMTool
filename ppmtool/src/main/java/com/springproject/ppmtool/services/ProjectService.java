package com.springproject.ppmtool.services;

import com.springproject.ppmtool.domain.Project;

public interface ProjectService {
	
	public Project saveOrUpdate(Project project);
	
	public Project findProjectByIdentifier(String projectId);
	
	public Iterable<Project> findAllProject();
	
	public void deleteProjectById(String projectId);
	
}
