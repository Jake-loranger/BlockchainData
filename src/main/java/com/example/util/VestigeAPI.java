package com.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.ASAAsset;
import com.example.models.ASALiquidityPool;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class VestigeAPI {

    public String getMethod(String apiUrl) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            
            in.close();
            con.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    public ASAAsset getASAData(String assetTicker) {
        String assetID = getAssetID(assetTicker);
        String apiUrl = "https://free-api.vestige.fi/asset/" + assetID + "/list";

        String output = getMethod(apiUrl);

        Gson gson = new Gson();
        ASAAsset assetData = gson.fromJson(output, ASAAsset.class);

        return assetData;
    }

    public String getAssetID(String assetTicker) {
        String apiUrl = "https://free-api.vestige.fi/assets/search?query=" + assetTicker + "&page=0&page_size=1";

        String output = getMethod(apiUrl);

        String jsonString = output.replace("[", "").replace("]", "");
        Gson gson = new Gson();
        JsonObject assetObject = gson.fromJson(jsonString, JsonObject.class);

        String assetID = assetObject.get("id").getAsString();

        return assetID;
    }

    public ArrayList<ASALiquidityPool> getASAExchangeData(ASAAsset assetData) {
        ArrayList<ASALiquidityPool> liquidityPools = new ArrayList<ASALiquidityPool>();
        final String[] exchanges = { "T3", "PT", "H2", "UT" };
        final Long assetID = assetData.getId();

        for (String exchange : exchanges) {
            String apiUrl = "https://free-api.vestige.fi/pools/" + exchange + "/volumes?currency=Algo";

            String output = getMethod(apiUrl);
            JSONArray assetArray = new JSONArray(output);

            for (int i = 0; i < assetArray.length(); i++) {
                JSONObject pool = assetArray.getJSONObject(i);
                
                int asset1 = pool.getInt("asset_1_id");
                boolean isAsset2 = pool.get("asset_2_id").equals(null);

                if (asset1 == assetID && isAsset2) {
                    ASALiquidityPool poolData = new ASALiquidityPool();

                    poolData.setExchange(exchange);
                    poolData.setPoolID(pool.getInt("id"));
                    poolData.setAssetTicker(assetData.getName());
                    poolData.setAssetPrice(assetData.getPrice());
                    poolData.setLiquidity(pool.getFloat("liquidity"));
                    poolData.setFee(pool.getFloat("fee"));
                    poolData.setVolume24h(pool.getFloat("volume24h"));

                    liquidityPools.add(poolData);
                }
            }
        }

        return liquidityPools;
    }
}
