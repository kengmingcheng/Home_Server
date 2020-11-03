package com.kmc.MiniServer.model;

public class TradeData {

    private final String model;

    private final Integer pk;

    private Trade fields;

    private static Integer tradeSerialNo = 0;

    public TradeData(Trade trade){
        this.model = "trade";
        this.pk = tradeSerialNo++;
        this.fields = trade;
    }

    public String getModel() {
        return model;
    }

    public Integer getPk() {
        return pk;
    }

    public Trade getFields() {
        return fields;
    }

    public void setFields(Trade trade) {
        this.fields = trade;
    }
}
