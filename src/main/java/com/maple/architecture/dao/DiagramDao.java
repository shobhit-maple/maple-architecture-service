package com.maple.architecture.dao;

import com.maple.architecture.service.model.DiagramEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagramDao extends Neo4jRepository<DiagramEntity, String> {

  List<DiagramEntity> findByProjectId(String projectId);

  Page<DiagramEntity> findByProjectId(String projectId, Pageable pageable);
}
