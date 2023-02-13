package com.project.ravinder.spring6webapp.repositories;

import com.project.ravinder.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
