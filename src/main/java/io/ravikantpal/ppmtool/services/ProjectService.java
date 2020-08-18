package io.ravikantpal.ppmtool.services;

import io.ravikantpal.ppmtool.domain.Project;
import io.ravikantpal.ppmtool.exceptions.ProjectIdException;
import io.ravikantpal.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }


    public Project findProjectByIdentifier(String projectId){
        return projectRepository.findByProjectIdentifier(projectId);
    }


    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }


    public void deleteProjectByIdentifier(String projectid){
        Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());

        if(project == null){
            throw  new  ProjectIdException("Cannot Project with ID '"+projectid+"'. This project does not exist");
        }

        projectRepository.delete(project);
    }

    public Project updateProjectByIdentifier(String projectId, Project project){
        Project projObj = projectRepository.findByProjectIdentifier(projectId);
        if(projObj == null){
            throw new ProjectIdException("Cannot Project with ID "+ projectId +". This project does not exist");
        }

        projObj.setDescription(project.getDescription());
        projObj.setProjectName(project.getProjectName());
        projObj.setUpdated_At(new Date());

        projectRepository.save(projObj);

        return projObj;

    }

}
