package com.example.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BlockchainData {
    // Set Data Model
    // private String API_KEY;
    // private URL obj;

    public BlockchainData() {

        // MY_CODE

        // API_KEY = "83F280F2-F2DA-495E-B1CC-D4EE75FCBDAC";
        // obj = new URL("https://rest.coinapi.io/jsonrpc?apikey={API_KEY}");
        // HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // con.setRequestMethod("GET");
        // con.addRequestProperty("x-api-key", API_KEY);
        // int responseCode = con.getResponseCode();
        // BufferedReader in = new BufferedReader(
        // new InputStreamReader(con.getInputStream())
        // );
        // String inputLine;
        // StringBuffer response = new StringBuffer();
        // while ((inputLine = in.readLine()) != null) {
        // response.append(inputLine);
        // }
        // in.close();
        // System.out.println(response.toString());
        // set respone equal to an instance of Data Model
        

        // COINAPI_CODE

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Builder()
                .url("https://rest.coinapi.io/v1/assets?filter_asset_id=BTC;ETH;ALGO")
                .method("GET", body)
                .addHeader("Accept", "text/plain")
                .addHeader("X-CoinAPI-Key", "83F280F2-F2DA-495E-B1CC-D4EE75FCBDAC")
                .build();
        Response response = client.newCall(request).execute();
    };
}