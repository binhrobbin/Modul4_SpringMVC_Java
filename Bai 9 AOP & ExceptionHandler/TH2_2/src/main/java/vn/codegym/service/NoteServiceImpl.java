package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Note;

import java.util.List;

@Service
public class NoteServiceImpl implements INoteService{
    @Autowired
    private INoteService noteService;

    @Override
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @Override
    public void save(Note note) {
        noteService.save(note);
    }

    @Override
    public void remove(int id) {
        noteService.remove(id);
    }
}
