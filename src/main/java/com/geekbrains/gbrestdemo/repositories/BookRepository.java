package com.geekbrains.gbrestdemo.repositories;

import com.geekbrains.gbrestdemo.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
