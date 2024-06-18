package vn.codegym.service;

import org.springframework.data.domain.Page;
import vn.codegym.model.Note;

import java.util.List;
import java.util.Optional;

public interface INoteService {
    List<Note> findAll();

    void save(Note book);

    void remove(int id);

    Optional<Note> findByCode(int code);
}
