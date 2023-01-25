package com.mongodb.test.controller;

import com.mongodb.test.model.Book;
import com.mongodb.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/test")
    public String test(){
        return "Hello from rosan";
    }

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        bookService.save(book);
//        bookService.save(new Book(1,"Rosan","Best book ever"));
        return "Book created";
    }

    @GetMapping("/showBooks")
    public List<Book> getBooks(){
        return bookService.findAll();
    }

    @GetMapping("/getBook/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return bookService.findById(id);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book bookUpdates){
        Book oldBook = bookService.findById(id).orElseThrow();

        oldBook.setName(bookUpdates.getName());
        oldBook.setDescription(bookUpdates.getDescription());

        Book updatedBook = bookService.save(oldBook);
        return updatedBook;
    }

    @DeleteMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteById(id);
        return "Book deleted";
    }

}
