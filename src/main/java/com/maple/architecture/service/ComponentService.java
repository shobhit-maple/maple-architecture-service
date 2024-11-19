package com.maple.architecture.service;

import com.maple.architecture.service.model.ComponentEntity;
import com.maple.architecture.service.model.DiagramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComponentService extends CommonService<ComponentEntity> {

  Page<ComponentEntity> getAll(String diagramId, Pageable pageable);

  void deleteAllByDiagramId(String diagramId);
}
