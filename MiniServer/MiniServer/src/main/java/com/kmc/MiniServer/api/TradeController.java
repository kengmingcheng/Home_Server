package com.kmc.MiniServer.api;

import com.kmc.MiniServer.model.Trade;
import com.kmc.MiniServer.model.TradeData;
import com.kmc.MiniServer.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("plantville/api/")
@RestController
public class TradeController {

    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService){
        this.tradeService = tradeService;
    }

    @PostMapping("trades")
    public int addTrade(@Valid Trade trade){
        return tradeService.addTrade(trade);
    }

    @GetMapping("trades")
    public List<TradeData> tradeHistory(){
        return tradeService.tradeHistory();
    }

    @GetMapping("trades/{id}")
    public TradeData getTradeById(@PathVariable("id") UUID id){
        return tradeService.getTradeById(id)
                .orElse(null);
    }

    @DeleteMapping("trades/{id}")
    public void deleteTradeById(@PathVariable("id") UUID id){
        tradeService.deletedTradeById(id);
    }

    @PostMapping("accept_trade")
    public void updateTradeById(Integer trade_id, String accepted_by){
        tradeService.updateTradeById(trade_id, accepted_by);
    }
}
