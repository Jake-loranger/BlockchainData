package com.example.models;

import org.springframework.data.annotation.Id;

import com.example.util.CoinAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "assetData")
public class AssetData extends CoinAPI {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String asset_id;
    private float price_usd;
    private float volume_1mth_usd;
    private float volume_1day_usd;
    private float volume_1hrs_usd;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetName() {
        return name;
    }

    public void setAssetName(String name) {
        this.name = name;
    }
    
    public String getAssetID() {
        return asset_id;
    }
    
    public void setAssetID(String asset_id) {
        this.asset_id = asset_id;
    }
    
    public float getPriceUSD() {
        return price_usd;
    }
    
    public void setPriceUSD(float price_usd) {
        this.price_usd = price_usd;
    }
    
    public float getMonthVolumeUSD() {
        return volume_1mth_usd;
    }
    
    public void setMonthVolumeUSD(float volume_1mth_usd) {
        this.volume_1mth_usd = volume_1mth_usd;
    }
    
    public float getDayVolumeUSD() {
        return volume_1day_usd;
    }
    
    public void setDayVolumeUSD(float volume_1day_usd) {
        this.volume_1day_usd = volume_1day_usd;
    }
    
    public float getHourVolumeUSD() {
        return volume_1hrs_usd;
    }
    
    public void setHourVolumeUSD(float volume_1hrs_usd) {
        this.volume_1hrs_usd = volume_1hrs_usd;
    }

    public void display() {
        System.out.println(
            "Asset: " + name + " (" + asset_id + ")\n" + 
            "Price: $" + price_usd + "\n" + 
            "Volume (hour): " + " $" + volume_1hrs_usd + " \n" +
            "Volume (day): " + " $" + volume_1day_usd + " \n" +
            "Volume (month): " + " $" + volume_1mth_usd + " \n"
        );
    }
}
