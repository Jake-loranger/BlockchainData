package com.example.models;

import com.example.util.CoinAPI;

public class AssetData extends CoinAPI {

    private String assetName;
    private double assetID;
    private double priceUSD;
    private double dayVolumeUSD;
    private double hourVolumeUSD;
    
    public String getAssetName() {
        return assetName;
    }
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    public double getAssetID() {
        return assetID;
    }
    public void setAssetID(double assetID) {
        this.assetID = assetID;
    }
    public double getPriceUSD() {
        return priceUSD;
    }
    public void setPriceUSD(double priceUSD) {
        this.priceUSD = priceUSD;
    }
    public double getDayVolumeUSD() {
        return dayVolumeUSD;
    }
    public void setDayVolumeUSD(double dayVolumeUSD) {
        this.dayVolumeUSD = dayVolumeUSD;
    }
    public double getHourVolumeUSD() {
        return hourVolumeUSD;
    }
    public void setHourVolumeUSD(double hourVolumeUSD) {
        this.hourVolumeUSD = hourVolumeUSD;
    }
    
}
