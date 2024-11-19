package com.maple.architecture.service.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Data
@Builder
@Node("Diagram")
@NoArgsConstructor
@AllArgsConstructor
public class DiagramEntity {

  @Id
  @GeneratedValue(UUIDStringGenerator.class)
  private String id;
  @NotNull
  @NotEmpty
  @Length(min = 3)
  private String name;
  @Nullable
  private String description;
  @Relationship(type = "CONTAINS_SERVICE", direction = Relationship.Direction.OUTGOING)
  private List<ComponentEntity> components;
  @NotNull
  @Relationship(type = "BELONGS_TO_FOLDER", direction = Relationship.Direction.INCOMING)
  private ProjectEntity project;
}
