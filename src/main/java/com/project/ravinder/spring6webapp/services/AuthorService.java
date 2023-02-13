package com.project.ravinder.spring6webapp.services;

import com.project.ravinder.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
