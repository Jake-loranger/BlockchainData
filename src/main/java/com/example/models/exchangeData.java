package com.example.models;

import com.example.util.CoinAPI;

public class ExchangeData extends CoinAPI {

    private String exchange_name;
    private float highest_bid_price;
    private float lowest_ask_price;
    private float spread;

    public String getExchange() {
        return exchange_name;
    }

    public void setExchange(String exchange_name) {
        this.exchange_name = exchange_name;
    }

    public float getHighest_bid_price() {
        return highest_bid_price;
    }

    public void setHighest_bid_price(float highest_bid_price) {
        this.highest_bid_price = highest_bid_price;
    }

    public float getLowest_ask_price() {
        return lowest_ask_price;
    }

    public void setLowest_ask_price(float lowest_ask_price) {
        this.lowest_ask_price = lowest_ask_price;
    }

    public float getSpread() {
        return spread;
    }

    public void setSpread(float spread) {
        this.spread = spread;
    }
}
