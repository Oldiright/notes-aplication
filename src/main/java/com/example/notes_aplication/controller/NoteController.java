package com.example.notes_aplication.controller;
import com.example.notes_aplication.model.Note;
import com.example.notes_aplication.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/note")
    public ModelAndView getStart() {
        return new ModelAndView("index");
    }
    @GetMapping("/note/list")
    public ModelAndView getList() {
        List<Note> notes = noteService.listAll();
        ModelAndView modelAndView = new ModelAndView("note-list");
        modelAndView.addObject("notes", notes);
        modelAndView.addObject("action", "listAll");
        return modelAndView;
    }
    @GetMapping("/note/create")
    public ModelAndView createProcessor() {
        ModelAndView modelAndView = new ModelAndView("note-list");
        modelAndView.addObject("action", "startCreating");
        return modelAndView;
    }
    @PostMapping("/note/create")
    public String createProcessor(@RequestParam String title, @RequestParam String content) {
        noteService.add(new Note(title, content));

        return "redirect:/note/list";
    }


    @GetMapping("/note/edit")
    public ModelAndView editProcessor(@RequestParam long id) {
        System.out.println(id);
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView("note-list");
        modelAndView.addObject("note", note);
        modelAndView.addObject("action", "startEditing");
        return modelAndView;
    }

    @PostMapping("/note/edit")
    public ModelAndView editProcessor(@RequestParam long id, @RequestParam String title, @RequestParam String content) {
        System.out.println("This from post mapping "+ id + " " + content + " " + title);
        Note note = new Note(id, title, content);
        noteService.update(note);
        note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView("note-list");
        modelAndView.addObject("note", note);
        modelAndView.addObject("action", "startEditing");
        return modelAndView;
    }
    @PostMapping("/note/delete")
    public String deleteNote(@RequestParam long id) {
        System.out.println("This from delete method post mapping "+ id);
        noteService.deleteById(id);
        return "redirect:/note/list";
    }



}
