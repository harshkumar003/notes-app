package com.harshkumar.notesapp.controller;

import com.harshkumar.notesapp.entity.Note;
import com.harshkumar.notesapp.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public Note createNote(@Valid @RequestBody Note note) {
        return noteService.saveNote(note);
    }

    // @RequestBody converts the JSON sent by the client into a Java Note object.

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {

        Optional<Note> note = noteService.getNoteById(id);

        if (note.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(note.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id,
                                           @RequestBody Note updatedNote) {

        Optional<Note> updated = noteService.updateNote(id, updatedNote);

        if (updated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {

        Optional<Note> deleted = noteService.deleteNote(id);

        if (deleted.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deleted.get());
    }
}