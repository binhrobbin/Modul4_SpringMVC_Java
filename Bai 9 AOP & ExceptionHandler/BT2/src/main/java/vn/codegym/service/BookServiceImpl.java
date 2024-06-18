package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Book;
import vn.codegym.repository.IBookRepository;

import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAllByFirstNameContaining(Pageable pageable, String name) {
        return bookRepository.findAllByNameContaining(pageable,name);
    }
}
