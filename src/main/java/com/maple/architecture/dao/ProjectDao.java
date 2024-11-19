package com.maple.architecture.dao;

import com.maple.architecture.service.model.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends Neo4jRepository<ProjectEntity, String> {

  Page<ProjectEntity> findByTeamId(String teamId, Pageable pageable);
}
