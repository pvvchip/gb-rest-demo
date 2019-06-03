package com.geekbrains.gbrestdemo.controllers;

import com.geekbrains.gbrestdemo.entities.Book;
import com.geekbrains.gbrestdemo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/**")
@RestController
public class BookRestController {
    private BookService bookService;

    @Autowired
    public void setBooksService(BookService bookService) {
        this.bookService = bookService;
    }

    @CrossOrigin
    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books")
    public List<Book> getBookById() {
        return bookService.getAllBookList();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {
        theBook.setId(0L);
        theBook = bookService.saveOrUpdate(theBook);
        return theBook;
    }

    @PutMapping(path = "/books", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Book updateBook(@RequestBody Book theBook) {
        theBook = bookService.saveOrUpdate(theBook);
        return theBook;
    }

    @DeleteMapping("/books/{bookId}")
    public int deleteBook(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return HttpStatus.OK.value();
    }
}
