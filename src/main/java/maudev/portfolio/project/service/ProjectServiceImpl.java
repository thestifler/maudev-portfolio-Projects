package maudev.portfolio.project.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.project.entity.Project;
import maudev.portfolio.project.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    
    @Override
    public Project createProject(Project project) {
        project.setStatus("CREATED");
        project.setCreateat(new Date());
        
        return projectRepository.save(project);
    }

    @Override
    public Project deleteProject(Long id) {
        Project projectDB = getProject(id);
        if (projectDB == null) {
            return null;
        }
        projectDB.setStatus("DELETED");
        return projectRepository.save(projectDB);
    }

    @Override
    public Project getProject(Long id) {
        
        Project projectDB = projectRepository.findByIdAndStatus(id, "CREATED");

        if (projectDB == null) {
            return null;
        }
        return projectDB;
    }

    @Override
    public Project updaProject(Project project) {
       Project projectDB = getProject(project.getId());

       if (projectDB == null) {
           return null;
       }

        projectDB.setName(project.getName());
        projectDB.setDescription(project.getDescription());
        projectDB.setResume(project.getResume());
        projectDB.setUrlgithub(project.getUrlgithub());
        projectDB.setUrlproject(project.getUrlproject());
        return projectRepository.save(projectDB);
    }
    
}
