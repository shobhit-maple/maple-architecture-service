package com.maple.architecture.service.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Data
@Builder
@Node("Component")
@NoArgsConstructor
@AllArgsConstructor
public class ComponentEntity {

  @Id
  @GeneratedValue(UUIDStringGenerator.class)
  private String id;

  private String name;
  private String type;
  private String description;

  @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
  private List<ConnectionEntity> outgoingCalls;

  @Relationship(type = "BELONGS_TO_DIAGRAM", direction = Relationship.Direction.INCOMING)
  private DiagramEntity diagram;
}
