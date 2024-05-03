package com.example;

import java.util.Map;

import com.example.models.AsaAsset;
import com.example.models.AssetData;
import com.example.models.ExchangeData;
import com.example.util.CoinAPI;
import com.example.util.VestigeAPI;

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

        // for (String exchangeID: exchangeIDs) {
        //     ExchangeData exchangeData = coinAPI.getExchangeData(assetIDBase, exchangeID);
        //     String exchange = exchangeData.getExchange();
        //     Map<String, Float> highestBid = exchangeData.getBids();
        //     Map<String, Float> lowestAsk = exchangeData.getAsks();
        //     float spread = exchangeData.getSpread();
        //     System.out.println(exchange + "\nLowest Ask: $" + lowestAsk.get("price") + "\nHighest Bid: $" + highestBid.get("price") + "\nSpread: " + spread + "\n");
        // }

    /* MARKDOWN - Prints asset data for the specified ASA Asset on Algorand */

        VestigeAPI vestigeAPI = new VestigeAPI(); 
        AsaAsset output = vestigeAPI.getASAData("ALGO");
        // System.out.println("Market Cap (ALGO): " + output.getMarketCap());
        // System.out.println("Fully Diluted Market Cap (ALGO): " + output.getFdmc());
        // System.out.println("Circulating Supply: % " + output.getCirculatingSupply());
        System.out.println("% " + output.getChange24h() * 100);
    }
}