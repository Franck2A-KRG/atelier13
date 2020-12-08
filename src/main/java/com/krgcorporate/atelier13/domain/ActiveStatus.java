package com.krgcorporate.atelier13.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActiveStatus implements Status {

    @Override
    public String getType() {
        return "active";
    }
}
