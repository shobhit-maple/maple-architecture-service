package com.maple.architecture.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentRequest {

  private String name;
  private String type;
  private String description;
  private String diagramId;
}
