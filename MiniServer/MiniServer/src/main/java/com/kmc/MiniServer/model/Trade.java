package com.kmc.MiniServer.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Trade {

    private UUID id;

    private String author;

    private String accepted_by;

    private float price;

    private boolean state;

    private int quantity;

    private Instant created_at;

    private Instant updated_at;

    public Trade(UUID id,
                 String author,
                 String accepted_by,
                 float price,
                 boolean state,
                 int quantity) {
        this.id = id;
        this.author = author;
        this.accepted_by = accepted_by;
        this.price = price;
        this.state = state;
        this.quantity = quantity;
        this.created_at = Instant.now();
        this.updated_at = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getAccepted_by() {
        return accepted_by;
    }

    public float getPrice() {
        return price;
    }

    public boolean isState() {
        return state;
    }

    public int getQuantity() {
        return quantity;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }
}
