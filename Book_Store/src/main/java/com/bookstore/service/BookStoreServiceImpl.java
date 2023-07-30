package com.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.dto.BookDto;
import com.bookstore.service.exceptions.BookNotFoundException;
import com.bookstore.service.exceptions.DuplicateResourceException;

import jakarta.transaction.Transactional;

@Service
class BookStoreServiceImpl implements BookStoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookStoreServiceImpl.class);
    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BookStoreServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Register new book with new identifier into database
     * Save the book In Book Domain
     * Maintain the count in BookCount Domain
     *
     * @param bookDto
     */
    @Override
    @Transactional
    public void addNewBook(BookDto bookDto) {
        //Check if bookDto is previously present
        Optional<Book> bookById = bookRepository.findById(bookDto.getId());
        bookById.ifPresent(book -> {
            throw new DuplicateResourceException("Book with same id present. " +
                    "Either use update methods to update the book counts or use addBook(Long id, int quantityToAdd) methods");
        });
        if (!bookById.isPresent()) {
            LOGGER.info("No Duplicates found.");
            //Map bookDto to book
            Book book = modelMapper.map(bookDto, Book.class);
            //Set the status to available
            LOGGER.info("The data are mapped and ready to save.");

            //Save to book
            bookRepository.save(book);
        }
    }

    /**
     * This method adds the quantity of book if the book with given id is already registered.
     *
     * @param id
     * @param quantityToAdd
     */
    @Override
    public void addBook(Long id, int quantityToAdd) {
        //Get the book by id
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id:" + id + " is not registered. Use addNewBook to register."));
        LOGGER.info("The book with id " + id + " is registered");

        int totalCountAfterAdd = book.getTotalCount() + quantityToAdd;
        book.setTotalCount(totalCountAfterAdd);

        bookRepository.save(book);
    }

    /**
     * Get book by id
     *
     * @param id
     * @return bookdto
     */
    @Override
    public BookDto getBookById(Long id) {
        //Get the book from repo
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id:" + id + " is not found."));

        return modelMapper.map(book, BookDto.class);
    }


    /**
     * List all the books
     *
     * @return List<BookDto>
     */
    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return mapBookListToBooDtoList(books);
    }


    //Convert List of books to List of bookDto
    private List<BookDto> mapBookListToBooDtoList(List<Book> books) {
        return books.stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

	
}
