package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Note;
import vn.codegym.repository.INoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements INoteService{
    @Autowired
    private INoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Optional<Note> findByCode(int code) {
        return noteRepository.findByCode(code);
    }
}
