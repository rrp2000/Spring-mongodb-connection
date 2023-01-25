package com.mongodb.test.service;

import com.mongodb.test.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookService extends MongoRepository<Book,Integer> {

}
