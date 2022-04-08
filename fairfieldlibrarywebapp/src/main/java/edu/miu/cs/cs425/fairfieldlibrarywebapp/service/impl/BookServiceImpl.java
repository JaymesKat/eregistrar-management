package edu.miu.cs.cs425.fairfieldlibrarywebapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Book;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.repository.BookRepository;
import edu.miu.cs.cs425.fairfieldlibrarywebapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public Book updateBookById(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if(book != null) {
            book.setTitle("SpringBoot In Action 2nd Edition");
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        return bookRepository.getBookByISBN(isbn);
    }

}
