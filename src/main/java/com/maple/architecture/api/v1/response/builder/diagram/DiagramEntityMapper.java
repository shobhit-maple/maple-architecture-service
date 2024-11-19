package com.maple.architecture.api.v1.response.builder.diagram;

import com.maple.architecture.api.v1.request.DiagramRequest;
import com.maple.architecture.api.v1.response.DiagramResponse;
import com.maple.architecture.api.v1.response.DiagramResponse.DiagramData;
import com.maple.architecture.service.ProjectService;
import com.maple.architecture.service.model.DiagramEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DiagramEntityMapper {

  private final ProjectService projectService;

  public DiagramEntity mapForPost(final DiagramRequest request) {
    return DiagramEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .project(projectService.get(request.getProjectId()))
        .build();
  }

  public DiagramEntity mapForPut(final DiagramEntity entity, final DiagramRequest request) {
    entity.setName(request.getName());
    entity.setDescription(request.getDescription());
    entity.setProject(projectService.get(request.getProjectId()));
    return entity;
  }

  public DiagramEntity mapForPatch(final DiagramEntity entity, final DiagramRequest request) {
    if (request.getName() != null && !request.getName().equals(entity.getName())) {
      entity.setName(request.getName());
    }
    if (request.getDescription() != null
        && !request.getDescription().equals(entity.getDescription())) {
      entity.setDescription(request.getDescription());
    }
    if (request.getProjectId() != null && !request.getProjectId().equals(entity.getId())) {
      entity.setProject(projectService.get(request.getProjectId()));
    }
    return entity;
  }

  public DiagramResponse entityToResponse(final DiagramEntity entity) {
    return DiagramResponse.builder()
        .id(entity.getId())
        .data(
            DiagramData.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .projectId(entity.getProject().getId())
                .build())
        .build();
  }
}
