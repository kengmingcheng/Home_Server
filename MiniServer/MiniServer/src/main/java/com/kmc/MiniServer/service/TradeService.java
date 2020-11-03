package com.kmc.MiniServer.service;

import com.kmc.MiniServer.dao.PlantvilleDao;
import com.kmc.MiniServer.model.Trade;
import com.kmc.MiniServer.model.TradeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TradeService {
    private final PlantvilleDao pDao;

    @Autowired
    public TradeService(@Qualifier("TempDao") PlantvilleDao pDao){
        this.pDao = pDao;
    }

    public int addTrade(Trade trade){
        pDao.insertTrade(trade);
        return 1;
    }

    public List<TradeData> tradeHistory(){
        return pDao.tradeHistory();
    }

    public Optional<TradeData> getTradeById(UUID id){
        return pDao.selectTradeById(id);
    }

    public int deletedTradeById(UUID id){
        return pDao.deleteTradeById(id);
    }

    public int deletedTradeById(Integer id){
        return pDao.deleteMessageById(id);
    }

    public int updateTradeById(Integer id, String accepted_by) {
        return pDao.updateTradeById(id, accepted_by);
    }
}
