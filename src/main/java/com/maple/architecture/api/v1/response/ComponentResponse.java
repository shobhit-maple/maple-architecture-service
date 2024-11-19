package com.maple.architecture.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentResponse {

  private String id;
  private ComponentData data;

  @Data
  @Builder
  public static class ComponentData {
    private String name;
    private String type;
    private String description;
    private String diagramId;
  }
}
