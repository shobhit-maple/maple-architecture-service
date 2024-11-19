package com.maple.architecture.service;

import com.alviss.commons.exception.NotFoundException;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommonService<T> {

  default T get(String id) {
    val entity = getDao().findById(id);
    if (entity.isEmpty()) {
      throw new NotFoundException("Requested entity is not found");
    }
    return entity.get();
  }

  Page<T> getAll(String parentId, Pageable pageable);

  default T save(T entity) {
    return getDao().save(entity);
  }

  void delete(T entity);

  Neo4jRepository<T, String> getDao();
}
