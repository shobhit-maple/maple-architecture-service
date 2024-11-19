package com.maple.architecture.service;

import com.maple.architecture.service.model.DiagramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiagramService extends CommonService<DiagramEntity> {

  Page<DiagramEntity> getAll(String projectId, Pageable pageable);

  void deleteAllByProjectId(String projectId);
}
