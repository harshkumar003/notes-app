package com.harshkumar.notesapp.controller;

import com.harshkumar.notesapp.entity.Note;
import com.harshkumar.notesapp.repository.NoteRepository;
import com.harshkumar.notesapp.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note){
        return noteService.saveNote(note);
    }

    //Note: @RequestBody converts the JSON sent by user into a Java object ie Note note in this case



}
