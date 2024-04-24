package com.example;

import com.example.util.CoinAPI;

public class App {
    private static String coin = "BTC";

    public static void main(String[] args) {
        CoinAPI coinAPI = new CoinAPI();
        String assetData = coinAPI.getAssetData(coin);
        System.out.println("Asset data for " + coin + ":");
        System.out.println(assetData);
    }
}