package com.kmc.MiniServer.dao;

import com.kmc.MiniServer.model.Chat;
import com.kmc.MiniServer.model.Trade;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("TempDao")
public class TempDao implements PlantvilleDao {

    private List<ChatData> chatDB = new ArrayList<>();

    private List<Trade> tradeDB = new ArrayList<>();

    private static Integer chatSerialNo = 0;

    // Chat block
    @Override
    public int insertMessage(Chat chat) {
        chatDB.add(0,new ChatData(chat));
        return 1;
    }

    @Override
    public List<ChatData> chatHistory() {
        return chatDB;
    }

    @Override
    public Optional<ChatData> selectMessageById(Integer id){
        return chatDB.stream()
                .filter(Chat -> Chat.getPk().equals(id))
                .findFirst();
    }

    @Override
    public int deleteMessageById(Integer id) {
        Optional<ChatData> chat = selectMessageById(id);
        if (chat.isEmpty()) return 0;
        else{
            chatDB.remove(chat.get());
            return 1;
        }
    }

    // Trade block
    @Override
    public int insertTrade(UUID id, Trade trade) {
        return 0;
    }

    @Override
    public List<Trade> tradeHistory() {
        return tradeDB;
    }

    @Override
    public Optional<Trade> selectTradeById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteTradeById(UUID id) {
        return 0;
    }

    @Override
    public int updateTradeById(UUID id) {
        return 0;
    }

}

