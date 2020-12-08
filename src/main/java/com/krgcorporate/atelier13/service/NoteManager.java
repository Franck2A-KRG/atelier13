package com.krgcorporate.atelier13.service;

import com.krgcorporate.atelier13.domain.Note;

import java.util.List;

public interface NoteManager {

    List<Note> findAllByContract(String contract);
}
