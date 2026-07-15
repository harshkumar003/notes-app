package com.harshkumar.notesapp.service;

import com.harshkumar.notesapp.entity.Note;
import com.harshkumar.notesapp.repository.NoteRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public Note saveNote(Note note){
        return noteRepository.save(note);
    }

    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }

}
