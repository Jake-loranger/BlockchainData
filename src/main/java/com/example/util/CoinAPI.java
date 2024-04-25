package com.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CoinAPI {
    private final static String API_KEY = "83F280F2-F2DA-495E-B1CC-D4EE75FCBDAC";

    public String getAssetData(String assetSymbol) {
        StringBuilder response = new StringBuilder();
        try {
            String apiUrl = "https://api.coinapi.io/v1/assets/" + assetSymbol;
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-CoinAPI-Key", API_KEY);
            
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

    public String getExchangeData( String symbolID ) {
        StringBuilder response = new StringBuilder();
        try {
            String apiURL = "https://rest.coinapi.io/v1/orderbooks/" + symbolID + "/current/?limit_levels=1";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-CoinAPI-Key", API_KEY);

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
}
