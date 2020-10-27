package com.kmc.MiniServer.dao;

import com.kmc.MiniServer.model.Chat;
import com.kmc.MiniServer.model.Trade;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlantvilleDao {

    // Chat block
    int insertMessage(Chat chat);

    List<ChatData> chatHistory();

    Optional<ChatData> selectMessageById(Integer id);

    int deleteMessageById(Integer id);

    // Trade block
    int insertTrade(UUID id, Trade trade);

    default int insertTrade(Trade trade){
        UUID id = trade.getId() == null ? UUID.randomUUID() : trade.getId();
        return insertTrade(id, trade);
    }

    List<Trade> tradeHistory();

    Optional<Trade> selectTradeById(UUID id);

    int deleteTradeById(UUID id);

    int updateTradeById(UUID id);

}
