package com.maple.architecture.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiagramResponse {

  private String id;
  private DiagramData data;

  @Data
  @Builder
  public static class DiagramData {
    private String name;
    private String description;
    private String projectId;
  }
}
