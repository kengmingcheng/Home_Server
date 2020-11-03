package com.kmc.MiniServer.dao;

import com.kmc.MiniServer.model.*;

import java.util.*;

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

    List<TradeData> tradeHistory();

    Optional<TradeData> selectTradeById(UUID id);

    Optional<TradeData> selectTradeById(Integer id);

    int deleteTradeById(UUID id);

    int updateTradeById(Integer id, String accepted_by);

    // save block
    int insertSave(String name, GameSave save);

    Map<String, GameSave> allSaves();

    Optional<GameSave> selectSaveByName(String name);

    int updateSaveByName(String name);

    int deleteSaveByName(String name);
}
