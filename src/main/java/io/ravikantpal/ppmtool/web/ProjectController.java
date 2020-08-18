package io.ravikantpal.ppmtool.web;

import io.ravikantpal.ppmtool.domain.Project;
import io.ravikantpal.ppmtool.services.MapValidationErrorService;
import io.ravikantpal.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
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

}