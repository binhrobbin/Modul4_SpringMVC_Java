package vn.codegym.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<E> {
    List<E> findAll();

    Optional<E> findById(Long id);

    E save(E e);

    void remove(Long id);
}