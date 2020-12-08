package com.krgcorporate.atelier13.service.impl;

import com.krgcorporate.atelier13.domain.Note;
import com.krgcorporate.atelier13.service.NoteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteManagerImpl implements NoteManager {

    private final Map<String, List<Note>> notes;

    @Autowired
    NoteManagerImpl() {
        this.notes = new HashMap<>();
    }

    @Override
    public List<Note> findAllByContract(String ref) {
        return notes.getOrDefault(ref, new ArrayList<>());
    }

    @Override
    public Note save(String ref, Note note) {
        note.setContract(ref);

        notes.computeIfAbsent(ref, k -> new ArrayList<>())
                .add(note);

        return note;
    }
}
