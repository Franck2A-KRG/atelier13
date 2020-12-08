package com.krgcorporate.atelier13.ws.graphql;

import com.krgcorporate.atelier13.domain.Note;
import com.krgcorporate.atelier13.service.NoteManager;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteQuery implements GraphQLQueryResolver {

    private final NoteManager noteManager;

    NoteQuery(NoteManager noteManager) {
        this.noteManager = noteManager;
    }

    public List<Note> findAllNotes(String ref) {
        return noteManager.findAllByContract(ref);
    }
}
