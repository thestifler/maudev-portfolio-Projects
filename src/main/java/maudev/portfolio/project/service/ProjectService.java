package maudev.portfolio.project.service;

import maudev.portfolio.project.entity.Project;

public interface ProjectService {
    

    public Project getProject(Long id);

    public Project createProject(Project project);
    public Project updaProject(Project project);
    public Project deleteProject(Long id);

}
