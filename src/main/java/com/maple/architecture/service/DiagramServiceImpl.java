package com.maple.architecture.service;

import com.maple.architecture.dao.DiagramDao;
import com.maple.architecture.service.model.DiagramEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DiagramServiceImpl implements DiagramService {

  private final DiagramDao dao;
  private final ComponentService componentService;

  public Page<DiagramEntity> getAll(String projectId, final Pageable pageable) {
    return dao.findByProjectId(projectId, pageable);
  }

  @Override
  public void deleteAllByProjectId(final String projectId) {
    dao.findByProjectId(projectId).forEach(this::delete);
  }

  @Override
  @Transactional
  public void delete(final DiagramEntity entity) {
    componentService.deleteAllByDiagramId(entity.getId());
    dao.delete(entity);
  }

  @Override
  public Neo4jRepository<DiagramEntity, String> getDao() {
    return dao;
  }
}
