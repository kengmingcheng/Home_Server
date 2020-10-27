package com.kmc.MiniServer.api;

import com.kmc.MiniServer.dao.ChatData;
import com.kmc.MiniServer.model.Chat;
import com.kmc.MiniServer.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("plantville/api/")
@RestController
public class ChatController {
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public void addMessage(@Valid @NonNull @RequestBody Chat chat){
        chatService.addMessage(chat);
    }

    @GetMapping
    public List<ChatData> chatHistory(){
        return chatService.chatHistory();
    }

    @GetMapping(path = "{id}")
    public ChatData getMessageById(@PathVariable("id") Integer id){
        return chatService.getMessageById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMessageById(@PathVariable("id") Integer id){
        chatService.deleteMessageById(id);
    }
}
