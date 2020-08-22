package io.ravikantpal.ppmtool.web;

import io.ravikantpal.ppmtool.domain.Project;
import io.ravikantpal.ppmtool.exceptions.ProjectIdException;
import io.ravikantpal.ppmtool.services.MapValidationErrorService;
import io.ravikantpal.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?>  errorMap = mapValidationErrorService.MapValidationErrorService(result);
        if(errorMap != null) return errorMap;

        Project obj = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(obj, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String projectId){
        Project proj = projectService.findProjectByIdentifier(projectId.toUpperCase());
        if(proj == null){
            throw new ProjectIdException("Project Id '"+projectId+"' does not exist");
        }
        return new ResponseEntity<Project>(proj, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProjects(){
        Iterable<Project> projects = projectService.findAllProjects();
        return new ResponseEntity<Iterable<Project>>(projects, HttpStatus.OK);

    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId){
        try {
            projectService.deleteProjectByIdentifier(projectId);
        }
        catch (Exception ex){
            throw new ProjectIdException("Project Id '"+projectId+"' does not exist");
        }
        return new ResponseEntity<String>("Project with ID: '"+projectId+"' was deleted", HttpStatus.OK);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> updateProjectByIdentifier(@PathVariable String projectId,@Valid @RequestBody Project project){
        Project saveProjectObj = projectService.updateProjectByIdentifier(projectId, project);

        return new ResponseEntity<String>("Updated successfully", HttpStatus.OK);
    }


}
