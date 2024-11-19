package com.maple.architecture.service;

import com.maple.architecture.dao.ComponentDao;
import com.maple.architecture.dao.DiagramDao;
import com.maple.architecture.service.model.ComponentEntity;
import com.maple.architecture.service.model.DiagramEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComponentServiceImpl implements ComponentService {

  private final ComponentDao dao;

  public Page<ComponentEntity> getAll(String diagramId, final Pageable pageable) {
    return dao.findByDiagramId(diagramId, pageable);
  }

  @Override
  public void deleteAllByDiagramId(final String diagramId) {
    dao.findByDiagramId(diagramId).forEach(this::delete);
  }

  @Override
  public void delete(final ComponentEntity entity) {
    dao.delete(entity);
  }

  @Override
  public Neo4jRepository<ComponentEntity, String> getDao() {
    return dao;
  }
}
