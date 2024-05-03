package com.example.models;

import com.example.util.VestigeAPI;

public class AsaAsset extends VestigeAPI {
    private Long id; 
    private String name; 
    private String ticker;
    private Float price; 
    private Float market_cap;
    private Float fdmc;
    private Float change24h;
    private Float volume24h;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getMarketCap() {
        return market_cap;
    }
    public void setMarketCap(Float market_cap) {
        this.market_cap = market_cap;
    }
    public Float getFdmc() {
        return fdmc;
    }
    public void setFdmc(Float fdmc) {
        this.fdmc = fdmc;
    }
    public Float getChange24h() {
        return change24h;
    }
    public void setChange24h(Float change24h) {
        this.change24h = change24h;
    }
    public Float getVolume24h() {
        return volume24h;
    }
    public void setVolume24h(Float volume24h) {
        this.volume24h = volume24h;
    }
    public Float getCirculatingSupply() {
        return market_cap / fdmc * 100;
    }
}
