package io.ravikantpal.ppmtool.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String ProjectName;

    private String ProjecIdentifier;

    private String Description;

    private Date StartDate;

    private Date EndDate;

    private Date CreatedAt;

    private Date UpdatedAt;

    public Project() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjecIdentifier() {
        return ProjecIdentifier;
    }

    public void setProjecIdentifier(String projecIdentifier) {
        ProjecIdentifier = projecIdentifier;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.CreatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.UpdatedAt = new Date();
    }


}
