package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface TODORepository extends CrudRepository<TODO, Long> {
}
