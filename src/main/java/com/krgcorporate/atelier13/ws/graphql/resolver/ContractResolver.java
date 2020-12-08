package com.krgcorporate.atelier13.ws.graphql.resolver;

import com.krgcorporate.atelier13.domain.Contract;
import com.krgcorporate.atelier13.domain.Note;
import com.krgcorporate.atelier13.service.NoteManager;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ContractResolver implements GraphQLResolver<Contract> {

    private final NoteManager noteManager;

    ContractResolver(NoteManager noteManager) {
        this.noteManager = noteManager;
    }

    public List<Note> getNotes(Contract contract) {
        log.info("resolve note");

        return noteManager.findAllByContract(contract.getRef());
    }
}
