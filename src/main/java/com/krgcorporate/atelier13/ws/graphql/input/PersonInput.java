package com.krgcorporate.atelier13.ws.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class PersonInput {

    private @NonNull String firstname;

    private @NonNull String lastname;
}
