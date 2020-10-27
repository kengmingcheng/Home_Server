package com.kmc.MiniServer.service;

import com.kmc.MiniServer.dao.ChatData;
import com.kmc.MiniServer.dao.PlantvilleDao;
import com.kmc.MiniServer.dao.TempDao;
import com.kmc.MiniServer.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    private final PlantvilleDao pDao;

    @Autowired
    public ChatService(@Qualifier("TempDao") PlantvilleDao pDao) {
        this.pDao = pDao;
    }

    public int addMessage(Chat chat){ return pDao.insertMessage(chat);}

    public List<ChatData> chatHistory(){
        return pDao.chatHistory();
    }

    public Optional<ChatData> getMessageById(Integer id){
        return pDao.selectMessageById(id);
    }

    public int deleteMessageById(Integer id){
        return pDao.deleteMessageById(id);
    }
}
