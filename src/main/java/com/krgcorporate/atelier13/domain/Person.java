package com.krgcorporate.atelier13.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Person {

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;
}
