package com.krgcorporate.atelier13.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@EqualsAndHashCode
public class Contract {

    @NonNull
    private String ref;

    @NonNull
    @EqualsAndHashCode.Exclude
    private Status status;

    @NonNull
    @EqualsAndHashCode.Exclude
    private List<Person> persons;

    @Builder
    public Contract(
            @NonNull String ref,
            @Nullable Status status,
            @Nullable List<Person> persons
    ) {
        this.ref = ref;
        this.status = Optional.ofNullable(status)
                .orElse(ActiveStatus.builder().build());
        this.persons = Optional.ofNullable(persons)
                .orElseGet(ArrayList::new);
    }
}
