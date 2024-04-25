package com.example;

import com.example.util.CoinAPI;

public class App {
    private static String assetIDBase = "Btc";
    private static String assetIDQuote = "USD";
    private static String[] exchangeIDs = {"BINANCE", "KRAKEN", "COINBASE", "GEMINI", "ITBIT", "KUCOIN"};

    public static void main(String[] args) {
        CoinAPI coinAPI = new CoinAPI();

    {/* Prints asset data (price, name, volume, etc.) for the specified assetIDBase */}

        // String assetData = coinAPI.getAssetData(assetIDBase);
        // System.out.println("Asset data for " + assetIDBase + ":");
        // System.out.println(assetData);


    {/* Prints exchange data (lowest ask price, highest bid price) for the specified assetIDBase */}

        for (String exchangeID: exchangeIDs) {
            String symbolID = exchangeID + "_SPOT_" + assetIDBase + "_" + assetIDQuote;
            String assetData = coinAPI.getExchangeData(symbolID);
            System.out.println("Quote data for " + symbolID + ":");
            System.out.println(assetData);
        }

    }
}