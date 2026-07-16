package com.harshkumar.notesapp.service;

import com.harshkumar.notesapp.entity.Note;
import com.harshkumar.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Optional<Note> updateNote(Long id, Note updatedNote) {

        Optional<Note> existing = noteRepository.findById(id);

        if (existing.isEmpty()) {
            return Optional.empty();
        }

        Note existingNote = existing.get();

        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setContent(updatedNote.getContent());

        Note savedNote = noteRepository.save(existingNote);

        return Optional.of(savedNote);
    }

    public Optional<Note> deleteNote(Long id) {

        Optional<Note> existing = noteRepository.findById(id);

        if (existing.isEmpty()) {
            return Optional.empty();
        }

        noteRepository.deleteById(id);

        return existing;
    }
}