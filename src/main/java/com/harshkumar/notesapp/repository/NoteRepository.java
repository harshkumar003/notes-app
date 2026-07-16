package com.harshkumar.notesapp.repository;

import com.harshkumar.notesapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {

}
