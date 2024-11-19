package com.maple.architecture.api.v1.response.builder.component;

import com.alviss.commons.api.model.Response;
import com.alviss.commons.exception.BadRequestException;
import com.alviss.commons.validator.CustomValidator;
import com.maple.architecture.api.v1.request.ComponentRequest;
import com.maple.architecture.api.v1.response.ComponentResponse;
import com.maple.architecture.api.v1.response.builder.diagram.DiagramEntityMapper;
import com.maple.architecture.service.ComponentService;
import com.maple.architecture.service.DiagramService;
import com.maple.architecture.service.model.ComponentEntity;
import com.maple.architecture.service.model.DiagramEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComponentApiHandler {

  private final ComponentService componentService;
  private final ComponentEntityMapper mapper;
  private final CustomValidator validator;

  public Response<ComponentResponse> handleGet(final String id) {
    val entity = componentService.get(id);
    return new Response<>(mapper.entityToResponse(entity));
  }

  public Response<List<ComponentResponse>> handleGetAll(
      final String projectId, final Pageable pageable) {
    val page = componentService.getAll(projectId, pageable);
    return new Response<>(
        page.get().map(mapper::entityToResponse).collect(Collectors.toList()), page);
  }

  public Response<ComponentResponse> handlePost(final ComponentRequest request) {
    val entity = mapper.mapForPost(request);
    validate(entity);
    return new Response<>(mapper.entityToResponse(componentService.save(entity)));
  }

  public Response<ComponentResponse> handlePatch(final String id, final ComponentRequest request) {
    val existingEntity = componentService.get(id);
    val updatedEntity = mapper.mapForPatch(existingEntity, request);
    validate(updatedEntity);
    return new Response<>(mapper.entityToResponse(componentService.save(updatedEntity)));
  }

  public Response<ComponentResponse> handlePut(final String id, final ComponentRequest request) {
    val existingEntity = componentService.get(id);
    val updatedEntity = mapper.mapForPut(existingEntity, request);
    validate(updatedEntity);
    return new Response<>(mapper.entityToResponse(componentService.save(updatedEntity)));
  }

  public void handleDelete(final String id) {
    val entity = componentService.get(id);
    componentService.delete(entity);
  }

  private void validate(final ComponentEntity entity) {
    val errors = validator.validate(entity);
    if (!errors.isEmpty()) {
      throw new BadRequestException("There are some validation errors", errors);
    }
  }
}
