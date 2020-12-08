package com.krgcorporate.atelier13.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class Note {

    @NonNull
    private String contract;

    @NonNull
    private String content;

    @Builder
    public Note(
            @NonNull String contract,
            @NonNull String content
    ) {
        this.contract = contract;
        this.content = content;
    }
}
