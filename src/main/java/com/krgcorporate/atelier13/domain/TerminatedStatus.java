package com.krgcorporate.atelier13.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Data
@Builder
public class TerminatedStatus implements Status {

    private final Reason reason;

    @Builder
    @JsonCreator
    TerminatedStatus(
            @NonNull Reason reason
    ) {
        this.reason = reason;
    }

    @Override
    public String getType() {
        return "terminated";
    }
}
