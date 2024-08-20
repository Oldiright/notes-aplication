package com.example.notes_aplication.service;
import com.example.notes_aplication.model.entity.Note;
import com.example.notes_aplication.model.entity.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;


    public List<Note> listAll() {
        return repository.findAll();
    }

    public void add(Note note) {
      repository.save(note);
    }

    public void deleteById(long id) {
        repository.deleteById(id);

    }
    public Note update(Note note) {
        return  repository.save(note);
    }

    public Note getById(long id){
        Note note;
        try {
            note = repository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            return null;
        }
            return repository.findById(id).orElseThrow();
    }
}
