package com.krgcorporate.atelier13.config;

import com.krgcorporate.atelier13.domain.ActiveStatus;
import com.krgcorporate.atelier13.domain.Contract;
import com.krgcorporate.atelier13.domain.Note;
import com.krgcorporate.atelier13.domain.Person;
import com.krgcorporate.atelier13.service.ContractManager;
import com.krgcorporate.atelier13.service.NoteManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class DataLoader {

    private final ContractManager contractManager;

    private final NoteManager noteManager;

    DataLoader(
            ContractManager contractManager,
            NoteManager noteManager
    ) {
        this.contractManager = contractManager;
        this.noteManager = noteManager;
    }

    @PostConstruct
    public void init() {
        contractManager.save(Contract.builder()
                .ref("A000001")
                .persons(Arrays.asList(Person.builder()
                        .firstname("John")
                        .lastname("Doe")
                        .build(), Person.builder()
                        .firstname("Jane")
                        .lastname("Doe")
                        .build()))
                .status(ActiveStatus.builder().build())
                .build());

        contractManager.save(Contract.builder()
                .ref("A000002")
                .persons(Arrays.asList(Person.builder()
                        .firstname("Bob")
                        .lastname("Foo")
                        .build(), Person.builder()
                        .firstname("Barbara")
                        .lastname("Foo")
                        .build()))
                .build());

        noteManager.save("A000001", Note.builder()
                .contract("A000001")
                .content("Note 1 sur A000001")
                .build());

        noteManager.save("A000001", Note.builder()
                .contract("A000001")
                .content("Note 2 sur A000001")
                .build());

        noteManager.save("A000002", Note.builder()
                .contract("A000002")
                .content("Note 3 sur A000001")
                .build());

        noteManager.save("A000002", Note.builder()
                .contract("A000002")
                .content("Note 4 sur A000001")
                .build());
    }
}
