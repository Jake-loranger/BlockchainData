package com.example.models;

import java.util.Map;

import com.example.util.CoinAPI;

public class ExchangeData extends CoinAPI {

    private String exchange_name;
    private Map<String, Float> asks;
    private Map<String, Float> bids;
    private float spread;

    


    public String getExchange() {
        return exchange_name;
    }

    public void setExchange(String exchange_name) {
        this.exchange_name = exchange_name;
    }

    public Map<String, Float> getAsks() {
        return asks;
    }

    public void setAsks(Map<String, Float> asks) {
        this.asks = asks;
    }

    public Map<String, Float> getBids() {
        return bids;
    }

    public void setBids(Map<String, Float> bids) {
        this.bids = bids;
    }

    public float getSpread() {
        this.spread =  asks.get("price") - bids.get("price");
        return spread;
    }
}
