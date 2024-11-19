package com.maple.architecture.api.v1.response.builder.component;

import com.maple.architecture.api.v1.request.ComponentRequest;
import com.maple.architecture.api.v1.response.ComponentResponse;
import com.maple.architecture.api.v1.response.ComponentResponse.ComponentData;
import com.maple.architecture.api.v1.response.DiagramResponse;
import com.maple.architecture.api.v1.response.DiagramResponse.DiagramData;
import com.maple.architecture.service.DiagramService;
import com.maple.architecture.service.model.ComponentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComponentEntityMapper {

  private final DiagramService diagramService;

  public ComponentEntity mapForPost(final ComponentRequest request) {
    return ComponentEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .type(request.getType())
        .diagram(diagramService.get(request.getDiagramId()))
        .build();
  }

  public ComponentEntity mapForPut(final ComponentEntity entity, final ComponentRequest request) {
    entity.setName(request.getName());
    entity.setDescription(request.getDescription());
    entity.setType(request.getType());
    entity.setDiagram(diagramService.get(request.getDiagramId()));
    return entity;
  }

  public ComponentEntity mapForPatch(final ComponentEntity entity, final ComponentRequest request) {
    if (request.getName() != null && !request.getName().equals(entity.getName())) {
      entity.setName(request.getName());
    }
    if (request.getDescription() != null
        && !request.getDescription().equals(entity.getDescription())) {
      entity.setDescription(request.getDescription());
    }
    if (request.getType() != null && !request.getType().equals(entity.getType())) {
      entity.setType(request.getType());
    }
    if (request.getDiagramId() != null && !request.getDiagramId().equals(entity.getId())) {
      entity.setDiagram((diagramService.get(request.getDiagramId())));
    }
    return entity;
  }

  public ComponentResponse entityToResponse(final ComponentEntity entity) {
    return ComponentResponse.builder()
        .id(entity.getId())
        .data(
            ComponentData.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .type(entity.getType())
                .diagramId(entity.getDiagram().getId())
                .build())
        .build();
  }
}
