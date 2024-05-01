package com.example;

import com.google.gson.Gson;

import com.example.models.AssetData;
import com.example.util.CoinAPI;

public class App {
    private static String assetIDBase = "BTC";
    private static String[] exchangeIDs = {"BINANCE", "KRAKEN", "COINBASE", "GEMINI", "ITBIT", "KUCOIN"};

    public static void main(String[] args) {
        CoinAPI coinAPI = new CoinAPI();
        
    /* MARKDOWN - Prints asset data (price, name, volume, etc.) for the specified asset */

        // AssetData assetData = coinAPI.getAssetData(assetIDBase);
        
        // System.out.println("Asset: " + assetData.getAssetName() + " (" + assetData.getAssetID() + ")");
        // System.out.println("Price (USD): " + " $" + assetData.getPriceUSD());
        // System.out.println("Month Volume (USD): " + " $" + assetData.getMonthVolumeUSD());
        // System.out.println("Hour Volume (USD): " + " $" + assetData.getHourVolumeUSD());
        // System.out.println("Day Volume (USD): " + " $" + assetData.getDayVolumeUSD());
        

    /* MARKDOWN - Prints exchange data (lowest ask price, highest bid price) for the specified asset\ */

        for (String exchangeID: exchangeIDs) {
            String symbolID = exchangeID + "_SPOT_" + assetIDBase + "_USD";
            String assetData = coinAPI.getExchangeData(symbolID);
            System.out.println("Quote data for " + symbolID + ":");
            System.out.println(assetData + "\n");
        }

    }
}