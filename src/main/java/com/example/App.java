package com.example;

import com.google.gson.Gson;

import com.example.models.AssetData;
import com.example.util.CoinAPI;

public class App {
    private static String assetIDBase = "Btc";
    private static String assetIDQuote = "USD";
    private static String[] exchangeIDs = {"BINANCE", "KRAKEN", "COINBASE", "GEMINI", "ITBIT", "KUCOIN"};

    public static void main(String[] args) {
        CoinAPI coinAPI = new CoinAPI();
        AssetData dataObj = new AssetData();
        
    /* Prints asset data (price, name, volume, etc.) for the specified assetIDBase */
        String assetDataString = coinAPI.getAssetData(assetIDBase);
        dataObj = getAssetDataObject(assetDataString);

        System.out.println("Asset data string for " + assetIDBase + ":");
        System.out.println(assetDataString);
        
        System.out.println("Asset data object for " + assetIDBase + ":");
        System.out.println(dataObj);
        

    /* Prints exchange data (lowest ask price, highest bid price) for the specified assetIDBase */

        // for (String exchangeID: exchangeIDs) {
        //     String symbolID = exchangeID + "_SPOT_" + assetIDBase + "_" + assetIDQuote;
        //     String assetData = coinAPI.getExchangeData(symbolID);
        //     System.out.println("Quote data for " + symbolID + ":");
        //     System.out.println(assetData + "\n");
        // }

    }

    private static AssetData getAssetDataObject(String jsonString) {
        Gson gson = new Gson(); 
        AssetData assetData = gson.fromJson(jsonString, AssetData.class);
        return assetData;
    }
}