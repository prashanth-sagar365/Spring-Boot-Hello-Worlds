package com.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.constants.Category;
import com.bookstore.service.BookStoreService;
import com.bookstore.service.dto.BookDto;
import com.bookstore.service.dto.SellDto;


/**
 * Controller for the bookstore projects
 * Acceptance Criterias:
 * 1)Add a book
 * 2)get books by Id
 * 3)get all books
 * 4)get number of books available by Id
 * 5)update a book
 * 6)sell a book
 * 7)sell a list of books
 * 8)get book(s) by category/keywords
 * 9)get number of books sold per category/keyword
 */
@RestController
@RequestMapping("/api")
//@Api(value = "Bookstore Controller", description = "Bookstore REST Endpoints.")
public class BookStoreController {

    private final BookStoreService bookStoreService;

    @Autowired
    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    /**
     * AC:  1)Add a book
     * This add new book with new Identifier.
     *
     * @param bookDto
     */
   // @ApiOperation(value = "Add New Book")
    @PostMapping("/add-new-book")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewBook(@Valid @RequestBody BookDto bookDto) {
        bookStoreService.addNewBook(bookDto);
    }

    /**
     * AC: 1)Add a book
     * This method add quantity of book to the books which are already registered.
     *
     * @param id
     * @param quantityToAdd
     */
    //@ApiOperation(value = "Add books")
    @PutMapping("/add-book/{id}/{quantityToAdd}")
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@PathVariable Long id,
                        @PathVariable int quantityToAdd) {
        bookStoreService.addBook(id, quantityToAdd);
    }

    /**
     * AC: 2)get books by id
     *
     * @param id
     * @return bookDto
     */
   // @ApiOperation(value = "Get Book By Id")
    @GetMapping("/book/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookStoreService.getBookById(id);
    }


    /**
     * AC: 3)Get All Books
     *
     * @return List<BookDto>
     */
   // @ApiOperation(value = "Get All Books")
    @GetMapping("/book-list")
    public List<BookDto> getAllBooks() {
        return bookStoreService.getAllBooks();
    }

    

}
