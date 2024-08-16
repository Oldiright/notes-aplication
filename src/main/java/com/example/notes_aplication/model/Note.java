package com.example.notes_aplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Note {
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public Note(long id, String title, String content) {
        this.id= id;
        this.title = title;
        this.content = content;
    }
    private long id;
    private String title;
    private String content;
}

