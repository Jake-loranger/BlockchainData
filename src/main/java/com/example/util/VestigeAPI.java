package com.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.amazonaws.util.StringInputStream;
import com.example.models.AsaAsset;
import com.example.models.AssetData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class VestigeAPI {
    
    public AsaAsset getASAData(String assetTicker){
        String assetID = getAssetID(assetTicker);

        StringBuilder response = new StringBuilder();
        String apiUrl = "https://free-api.vestige.fi/asset/" + assetID + "/list";

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

        Gson gson = new Gson();
        AsaAsset assetData = gson.fromJson((response.toString()), AsaAsset.class);
        
        return assetData;
    } 

    public String getAssetID(String assetTicker) {
        StringBuilder response = new StringBuilder();
        String apiUrl = "https://free-api.vestige.fi/assets/search?query=" + assetTicker + "&page=0&page_size=1";

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

        String jsonString = response.toString().replace("[", "").replace("]", "");
        Gson gson = new Gson(); 
        JsonObject assetObject = gson.fromJson(jsonString, JsonObject.class);

        String assetID = assetObject.get("id").getAsString();

        return assetID;
    }

}
