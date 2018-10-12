package com.fiaschettodevin.guru.springframework.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiaschettodevin.guru.springframework.spring5webapp.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
