package com.springproject.ppmtool.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springproject.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	@Override
	Iterable<Project> findAllById(Iterable<Long> arg0);
	
	Project findByProjectIdentifier(String projectIdentifier);

	@Override
	Iterable<Project> findAll();
	
	
	
}
