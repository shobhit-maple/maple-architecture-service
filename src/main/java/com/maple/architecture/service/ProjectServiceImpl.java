package com.maple.architecture.service;

import com.maple.architecture.dao.ProjectDao;
import com.maple.architecture.service.model.ProjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private final ProjectDao dao;
  private final DiagramService diagramService;

  public Page<ProjectEntity> getAll(final String teamId, final Pageable pageable) {
    return dao.findByTeamId(teamId, pageable);
  }

  @Transactional
  public void delete(final ProjectEntity entity) {
    diagramService.deleteAllByProjectId(entity.getId());
    dao.delete(entity);
  }

  @Override
  public Neo4jRepository<ProjectEntity, String> getDao() {
    return dao;
  }
}
