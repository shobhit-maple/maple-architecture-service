package com.maple.architecture.api.v1.response.builder.diagram;

import com.alviss.commons.api.model.Response;
import com.alviss.commons.exception.BadRequestException;
import com.alviss.commons.validator.CustomValidator;
import com.maple.architecture.api.v1.request.DiagramRequest;
import com.maple.architecture.api.v1.response.DiagramResponse;
import com.maple.architecture.service.DiagramService;
import com.maple.architecture.service.ProjectService;
import com.maple.architecture.service.model.DiagramEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DiagramApiHandler {

  private final DiagramService diagramService;
  private final DiagramEntityMapper mapper;
  private final CustomValidator validator;

  public Response<DiagramResponse> handleGet(final String id) {
    val entity = diagramService.get(id);
    return new Response<>(mapper.entityToResponse(entity));
  }

  public Response<List<DiagramResponse>> handleGetAll(
      final String projectId, final Pageable pageable) {
    val page = diagramService.getAll(projectId, pageable);
    return new Response<>(
        page.get().map(mapper::entityToResponse).collect(Collectors.toList()), page);
  }

  public Response<DiagramResponse> handlePost(final DiagramRequest request) {
    val entity = mapper.mapForPost(request);
    validate(entity);
    return new Response<>(mapper.entityToResponse(diagramService.save(entity)));
  }

  public Response<DiagramResponse> handlePatch(final String id, final DiagramRequest request) {
    val existingEntity = diagramService.get(id);
    val updatedEntity = mapper.mapForPatch(existingEntity, request);
    validate(updatedEntity);
    return new Response<>(mapper.entityToResponse(diagramService.save(updatedEntity)));
  }

  public Response<DiagramResponse> handlePut(final String id, final DiagramRequest request) {
    val existingEntity = diagramService.get(id);
    val updatedEntity = mapper.mapForPut(existingEntity, request);
    validate(updatedEntity);
    return new Response<>(mapper.entityToResponse(diagramService.save(updatedEntity)));
  }

  public void handleDelete(final String id) {
    val entity = diagramService.get(id);
    diagramService.delete(entity);
  }

  private void validate(final DiagramEntity entity) {
    val errors = validator.validate(entity);
    if (!errors.isEmpty()) {
      throw new BadRequestException("There are some validation errors", errors);
    }
  }
}
