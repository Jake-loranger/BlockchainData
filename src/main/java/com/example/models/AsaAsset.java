package com.example.models;

public class ASAAsset {
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

    public void display() {
        System.out.println( 
            "Name: " + name + "\n" +
            "ID: " + id + '\n' + 
            "Price: " + price + " ALGO \n" + 
            "Volume: " + volume24h + " ALGO \n" + 
            "Market Cap: " + market_cap + " ALGO \n" + 
            "Fully Diluted Market Cap: " + fdmc + " ALGO \n" + 
            "Circulating Supply: " + (market_cap/fdmc*100) + " %\n" + 
            "24 Hour Price Change: " + change24h + " % \n"
        );
    }

}
