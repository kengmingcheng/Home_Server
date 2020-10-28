package com.kmc.MiniServer.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class Chat {

    @NotBlank
    private final String username;

    private final String message;

    private final Instant created_at;

    private final Instant updated_at;

    public Chat(@JsonProperty("username") String username,
                @JsonProperty("message") String message) {
        this.username = username;
        this.message = message;
        created_at = Instant.now();
        updated_at = Instant.now();
    }

    public String getUsername() {
        return username;
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
        return username + " : " + message;
    }
}
