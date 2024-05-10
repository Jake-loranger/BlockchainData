package com.example.models;

public class ASALiquidityPool {
    private String exchange;
    private int poolID;
    private String assetTicker;
    private Float assetPrice;
    private Float algoPrice;
    private Float liquidity; 
    private Float fee; 
    private Float volume24h;

    public String getExchange() {
        return exchange;
    }
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
    public int getPoolID() {
        return poolID;
    }
    public void setPoolID(int poolID) {
        this.poolID = poolID;
    }
    public String getAssetTicker() {
        return assetTicker;
    }
    public void setAssetTicker(String assetTicker) {
        this.assetTicker = assetTicker;
    }
    public Float getAssetPrice() {
        return assetPrice;
    }
    public void setAssetPrice(Float assetPrice) {
        this.assetPrice = assetPrice;
    }
    public Float getAlgoPrice() {
        return algoPrice;
    }
    public void setAlgoPrice(Float algoPrice) {
        this.algoPrice = algoPrice;
    }
    public Float getLiquidity() {
        return liquidity;
    }
    public void setLiquidity(Float liquidity) {
        this.liquidity = liquidity;
    }
    public Float getFee() {
        return fee;
    }
    public void setFee(Float fee) {
        this.fee = fee;
    }
    public Float getVolume24h() {
        return volume24h;
    }
    public void setVolume24h(Float volume24h) {
        this.volume24h = volume24h;
    }

    public void display() {
        System.out.println( 
            "Exchange: " + exchange + "\n" +
            "Pool: " + assetTicker + " / " + " ALGO \n" +
            "Price: " + assetPrice + " ALGO \n" +
            "Liquidity: " + liquidity + " ALGO \n" + 
            "Volume (24 Hours): " + volume24h + " ALGO \n" +
            "Fee: " + fee + " ALGO \n"
        );
    }
}
