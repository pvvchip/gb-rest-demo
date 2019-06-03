package com.geekbrains.gbrestdemo.services;

import com.geekbrains.gbrestdemo.entities.Book;
import com.geekbrains.gbrestdemo.repositories.BookRepository;
import com.geekbrains.gbrestdemo.utils.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBooksRepository(BookRepository booksRepository) {
        this.bookRepository = booksRepository;
    }

    // get
    public Book getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new BookNotFoundException("Book with id = " + id + " not found");
        }
        return book.get();
    }

    // post put
    public Book saveOrUpdate(Book book) {
        return bookRepository.save(book);
    }

    // delete
    public void delete(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()) {
            throw new BookNotFoundException("Book with id = " + id + " not found");
        }
        bookRepository.delete(book.get());
    }

    // get
    public List<Book> getAllBookList() {
        return (List<Book>) bookRepository.findAll();
    }
}
