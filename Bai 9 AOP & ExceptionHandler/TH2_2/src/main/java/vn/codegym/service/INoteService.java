package vn.codegym.service;

import vn.codegym.model.Note;

import java.util.List;

public interface INoteService {
    List<Note> findAll();

    void save(Note book);

    void remove(int id);
}
