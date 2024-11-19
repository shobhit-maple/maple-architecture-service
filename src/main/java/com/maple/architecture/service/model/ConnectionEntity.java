package com.maple.architecture.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.TargetNode;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Node("Connection")
public class ConnectionEntity {

  @Id
  @GeneratedValue(UUIDStringGenerator.class)
  private String id;
  @TargetNode
  private ComponentEntity targetComponent;
}