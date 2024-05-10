package com.example;

import java.util.ArrayList;
import java.util.Map;

import com.example.models.ASAAsset;
import com.example.models.ASALiquidityPool;
import com.example.models.AssetData;
import com.example.models.ExchangeData;
import com.example.util.CoinAPI;
import com.example.util.VestigeAPI;

public class App {
    public static void main(String[] args) {
        CoinAPI coinAPI = new CoinAPI();
        VestigeAPI vestigeAPI = new VestigeAPI(); 
        
    /* MARKDOWN - Prints asset data (price, name, volume, etc.) for the specified asset */
        AssetData assetData = coinAPI.getAssetData("ALGO");
        assetData.display();
        

    /* MARKDOWN - Prints exchange data (lowest ask price, highest bid price) for the specified asset\ */
        // String[] exchangeIDs = {"KRAKEN", "COINBASE", "GEMINI", "ITBIT"};
        // for (String exchangeID: exchangeIDs) {
        //     ExchangeData exchangeData = coinAPI.getExchangeData("BTC", exchangeID);
        //     String exchange = exchangeData.getExchange();
        //     Map<String, Float> highestBid = exchangeData.getBids();
        //     Map<String, Float> lowestAsk = exchangeData.getAsks();
        //     float spread = exchangeData.getSpread();
        //     System.out.println(exchange + "\nLowest Ask: $" + lowestAsk.get("price") + "\nHighest Bid: $" + highestBid.get("price") + "\nSpread: " + spread + "\n");
        // }

    /* MARKDOWN - Prints asset data for the specified ASA Asset on Algorand */
        ASAAsset asaAssetData = vestigeAPI.getASAData("chip");
        asaAssetData.display();

    /* MARKDOWN - Prints exchange data for a specific ASA/ALGO combination */
        ArrayList<ASALiquidityPool> liquidityPools = vestigeAPI.getASAExchangeData(asaAssetData);
        for (ASALiquidityPool liquidityPool: liquidityPools) {
            liquidityPool.display();
        }
    }
}