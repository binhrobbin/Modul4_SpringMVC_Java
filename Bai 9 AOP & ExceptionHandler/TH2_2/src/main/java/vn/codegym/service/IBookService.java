package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Book;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Optional<Book> findById(int id);

    void remove(int id);

    Page<Book> findAllByFirstNameContaining(Pageable pageable, String name);
}
