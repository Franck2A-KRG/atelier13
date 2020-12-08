package com.krgcorporate.atelier13.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ActiveStatus.class, name = "active"),
        @JsonSubTypes.Type(value = TerminatedStatus.class, name = "terminated")
})
public interface Status {

    public String getType();
}
