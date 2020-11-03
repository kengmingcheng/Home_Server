package com.kmc.MiniServer.model;

import com.kmc.MiniServer.model.Chat;

public class ChatData {
    private String model;

    private Integer pk;

    private Chat fields;

    private static Integer chatSerialNo = 0;

    public ChatData(Chat chat) {
        this.model = "chat";
        this.pk = chatSerialNo++;
        this.fields = chat;
    }

    public String getModel() {
        return model;
    }

    public Integer getPk() {
        return pk;
    }

    public Chat getFields() {
        return fields;
    }
}
