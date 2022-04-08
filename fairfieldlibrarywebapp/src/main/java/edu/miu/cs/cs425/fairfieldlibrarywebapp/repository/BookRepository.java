package edu.miu.cs.cs425.fairfieldlibrarywebapp.repository;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    // Custom query using JPQL
    @Query(value = "select b from Book b where b.isbn = :isbn")
    public abstract Book getBookByISBN(String isbn);

    // Using Query methods
//    public abstract List<Book> findBooksByTitleStartingWith(String titleStart);
//    List<Book> findBooksByTitleContainingAndAndDatePublished_MonthOrderByTitle(String title, LocalDate date);

}
