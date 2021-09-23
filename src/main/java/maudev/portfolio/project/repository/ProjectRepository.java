package maudev.portfolio.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    

    public Project findByIdAndStatus(Long id , String status);
}
