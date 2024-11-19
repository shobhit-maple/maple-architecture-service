package com.maple.architecture.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiagramRequest {

  private String name;
  private String description;
  private String projectId;
}
