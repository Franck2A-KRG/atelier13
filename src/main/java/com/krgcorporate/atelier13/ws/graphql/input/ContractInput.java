package com.krgcorporate.atelier13.ws.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractInput {

    private @NonNull String ref;

    private @Nullable StatusInput status;

    private @Nullable List<PersonInput> persons;
}
