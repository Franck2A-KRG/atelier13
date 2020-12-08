package com.krgcorporate.atelier13.ws.rest;

import com.krgcorporate.atelier13.domain.Note;
import com.krgcorporate.atelier13.service.NoteManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contracts/{ref}/notes")
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor_ = @Autowired)
public class NoteController {

    private final NoteManager noteManager;

    @GetMapping
    public List<Note> findAll(@PathVariable("ref") String ref) {
        return noteManager.findAllByContract(ref);
    }

    @PostMapping
    public Note post(
            @PathVariable("ref") String ref,
            @RequestBody Note note
    ) {
        return noteManager.save(ref, note);
    }
}
