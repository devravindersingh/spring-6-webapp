package com.project.ravinder.spring6webapp.services;

import com.project.ravinder.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
