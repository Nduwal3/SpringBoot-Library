package com.library.demo.repositories;

import com.library.demo.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Long> {
}
