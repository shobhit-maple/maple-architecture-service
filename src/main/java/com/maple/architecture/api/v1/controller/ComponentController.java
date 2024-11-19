package com.maple.architecture.api.v1.controller;

import com.alviss.commons.api.model.Response;
import com.alviss.commons.security.SecurityService;
import com.maple.architecture.api.v1.request.ComponentRequest;
import com.maple.architecture.api.v1.response.ComponentResponse;
import com.maple.architecture.api.v1.response.builder.component.ComponentApiHandler;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("ComponentControllerV1")
@AllArgsConstructor
@RequestMapping("/api/v1/components")
public class ComponentController {

  private final ComponentApiHandler apiHandler;
  private final SecurityService securityService;

  @GetMapping("/{id}")
  //  @PreAuthorize("@securityService.hasPermission('ROLE_DIRECTORY_READ')")
  public Response<ComponentResponse> get(@PathVariable final String id) {
    return apiHandler.handleGet(id);
  }

  @GetMapping
  //  @PreAuthorize("@securityService.hasPermission('ROLE_DIRECTORY_READ')")
  public Response<List<ComponentResponse>> getAll(
      @RequestParam("diagram_id") final String diagramId, final Pageable pageable) {
    return apiHandler.handleGetAll(diagramId, pageable);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  //  @PreAuthorize("@securityService.hasPermission('ROLE_DIRECTORY_CREATE')")
  public Response<ComponentResponse> post(@RequestBody final ComponentRequest request) {
    return apiHandler.handlePost(request);
  }

  @PutMapping("/{id}")
  //  @PreAuthorize("@securityService.hasPermission('ROLE_DIRECTORY_UPDATE')")
  public Response<ComponentResponse> put(
      @PathVariable final String id, @RequestBody final ComponentRequest request) {
    return apiHandler.handlePut(id, request);
  }

  @PatchMapping("/{id}")
  //  @PreAuthorize("@securityService.hasPermission('ROLE_DIRECTORY_UPDATE')")
  public Response<ComponentResponse> patch(
      @PathVariable final String id, @RequestBody final ComponentRequest request) {
    return apiHandler.handlePatch(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  //  @PreAuthorize("@securityService.hasPermission('ROLE_DIRECTORY_DELETE')")
  public void delete(@PathVariable final String id) {
    apiHandler.handleDelete(id);
  }
}
