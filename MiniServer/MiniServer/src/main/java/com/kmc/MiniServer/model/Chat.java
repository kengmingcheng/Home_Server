package com.kmc.MiniServer.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class Chat {

    private final String name;

    private final String message;

    private final Instant created_at;

    private final Instant updated_at;

    public Chat(@JsonProperty("username") String name,
                @JsonProperty("message") String message) {
        this.name = name;
        this.message = message;
        created_at = Instant.now();
        updated_at = Instant.now();
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    @Override
    public String toString(){
        return name + " : " + message;
    }
}
