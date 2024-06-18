package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Book;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findAllByNameContaining(Pageable pageable, String name);
}
