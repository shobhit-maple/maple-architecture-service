package com.maple.architecture.dao;

import com.maple.architecture.service.model.ComponentEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentDao extends Neo4jRepository<ComponentEntity, String> {

  List<ComponentEntity> findByDiagramId(String diagramId);

  Page<ComponentEntity> findByDiagramId(String diagramId, Pageable pageable);
}
