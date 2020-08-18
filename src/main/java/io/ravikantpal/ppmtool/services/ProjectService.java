package io.ravikantpal.ppmtool.services;

import io.ravikantpal.ppmtool.domain.Project;
import io.ravikantpal.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        // Logic - In later stage
        return projectRepository.save(project);
    }
}
