package com.example;

import java.util.Map;

import com.example.models.AssetData;
import com.example.models.ExchangeData;
import com.example.util.CoinAPI;

public class App {
    private static String assetIDBase = "BTC";
    private static String[] exchangeIDs = {"KRAKEN", "COINBASE", "GEMINI", "ITBIT"};

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
            ExchangeData assetData = coinAPI.getExchangeData(assetIDBase, exchangeID);
            // System.out.println(assetData.toString());
            String exchange = assetData.getExchange();
            Map<String, Float> highest_bid = assetData.getBids();
            Map<String, Float> lowest_ask = assetData.getAsks();
            float spread = assetData.getSpread();
            System.out.println(exchange + "\nLowest Ask: $" + lowest_ask.get("price") + "\nHighest Bid: $" + highest_bid.get("price") + "\nSpread: " + spread + "\n");
        }

    }
}