package com.kmc.MiniServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PathVariable;

public class GameSave {

    private String username;

    private Object money;

    private Object garden;

    private Object inventory;

    public GameSave(@PathVariable("username") String username,
                    @JsonProperty("money") Object money,
                    @JsonProperty("garden") Object garden,
                    @JsonProperty("inventory") Object inventory) {
        this.username = username;
        this.money = money;
        this.garden = garden;
        this.inventory = inventory;
    }

    public String getUsername() {
        return username;
    }

    public Object getMoney() {
        return money;
    }

    public Object getGarden() {
        return garden;
    }

    public Object getInventory() {
        return inventory;
    }
}
