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
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Data
@Builder
@Node("Project")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {

  @Id
  @GeneratedValue(UUIDStringGenerator.class)
  private String id;
  @NotNull
  @NotEmpty
  @Length(min = 3)
  private String name;
  @Nullable
  private String description;
  @NotNull
  @NotEmpty
  private String teamId;
  @Relationship(type = "HAS_DIAGRAM", direction = Relationship.Direction.OUTGOING)
  private List<DiagramEntity> diagrams;
}
