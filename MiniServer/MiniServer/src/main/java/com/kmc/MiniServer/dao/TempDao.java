package com.kmc.MiniServer.dao;

import com.kmc.MiniServer.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository("TempDao")
public class TempDao implements PlantvilleDao {

    private List<ChatData> chatDB = new ArrayList<>();

    private List<TradeData> tradeDB = new ArrayList<>();

    private Map<String, GameSave> saveDB = new HashMap<>();

    // Chat block
    @Override
    public int insertMessage(Chat chat) {
        chatDB.add(0,new ChatData(chat));
        return 1;
    }

    @Override
    public List<ChatData> chatHistory() {
        return chatDB.stream().limit(100).collect(Collectors.toList());
    }

    @Override
    public Optional<ChatData> selectMessageById(Integer id){
        return chatDB.stream()
                .filter(chat -> chat.getPk().equals(id))
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
        tradeDB.add(0, new TradeData(trade));
        return 0;
    }

    @Override
    public List<TradeData> tradeHistory() {
        return tradeDB.stream().limit(100).collect(Collectors.toList());
    }

    @Override
    public Optional<TradeData> selectTradeById(UUID id) {
        return tradeDB.stream()
                .filter(trade -> trade.getFields().getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<TradeData> selectTradeById(Integer id) {
        return tradeDB.stream()
                .filter(trade -> trade.getPk().equals(id))
                .findFirst();
    }

    @Override
    public int deleteTradeById(UUID id) {
        Optional<TradeData> trade = selectTradeById(id);
        if (trade.isEmpty()) return 0;
        else{
            tradeDB.remove(trade.get());
            return 1;
        }
    }

    @Override
    public int updateTradeById(Integer id, String accepted_by) {
        Optional<TradeData> trade = selectTradeById(id);
        if (trade.isEmpty()) return 0;
        else{
            trade.get().getFields().setState();
            trade.get().getFields().setUpdated_at();
            trade.get().getFields().setAccepted_by(accepted_by);
            return 1;
        }
    }

    // save block
    @Override
    public int insertSave(String name, GameSave save) {
        saveDB.put(name, save);
        return 1;
    }

    @Override
    public Map<String, GameSave> allSaves() {
        return saveDB;
    }

    @Override
    public Optional<GameSave> selectSaveByName(String name) {
        return Optional.ofNullable(saveDB.get(name));
    }

    @Override
    public int updateSaveByName(String name) {
        return 0;
    }

    @Override
    public int deleteSaveByName(String name) {
        return saveDB.remove(name) == null ? 0 : 1;
    }
}

