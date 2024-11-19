package com.maple.architecture.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

  private String id;
  private ProjectData data;

  @Data
  @Builder
  public static class ProjectData {
    private String name;
    private String description;
    private String teamId;
  }
}
