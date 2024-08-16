package com.example.notes_aplication.service;
import com.example.notes_aplication.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final Map<Long, Note> notes;

    public List<Note> listAll() {
        Set<Long> keys = notes.keySet();
        List<Note> result = new ArrayList<>();
        for(long key: keys) {
            result.add(notes.get(key));
        }
        return result;
    }

    public Note add(Note note) {
        long random = (long) (365* LocalDateTime.now().getDayOfYear()*LocalDateTime.now().getSecond()/Math.random());
        note.setId(random);
        notes.put(note.getId(), note);
        System.out.println(notes.get(random).getContent());
        return   note;
    }

    public void deleteById(long id) {
        notes.remove(id);

    }
    public void update(Note note) {
        notes.put(note.getId(), note);
    }

    public Note getById(long id){
        return notes.get(id);
    }
}
