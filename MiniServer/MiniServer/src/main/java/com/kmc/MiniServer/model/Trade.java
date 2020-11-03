package com.kmc.MiniServer.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class Trade {

    private UUID id;

    private String author;

    private String accepted_by;

    private float price;

    private String state;

    private String plant;

    private int quantity;

    private Instant created_at;

    private Instant updated_at;

    public Trade(String author,
                 float price,
                 String plant,
                 int quantity) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.price = price;
        this.state = "open";
        this.plant = plant;
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

    public void setAccepted_by(String accepted_by) { this.accepted_by = accepted_by; }

    public float getPrice() {
        return price;
    }

    public String getState() {
        return state;
    }

    public void setState() { state = "close"; }

    public String getPlant() { return plant;}

    public int getQuantity() {
        return quantity;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at() { updated_at = Instant.now(); }
}
