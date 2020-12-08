package com.krgcorporate.atelier13.ws.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
public class StatusInput {

    private @NonNull String type;

    private @Nullable String reason;
}
