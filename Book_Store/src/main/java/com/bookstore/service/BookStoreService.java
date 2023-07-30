package com.bookstore.service;

import java.util.List;
import java.util.Locale.Category;

import com.bookstore.service.dto.BookDto;
import com.bookstore.service.dto.SellDto;

public interface BookStoreService {
    void addNewBook(BookDto bookDto);

    void addBook(Long id, int quantityToAdd);

    BookDto getBookById(Long id);

    List<BookDto> getAllBooks();

   
}
