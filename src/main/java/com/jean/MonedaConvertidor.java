package com.jean;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import okhttp3.*;

public class MonedaConvertidor implements Convertidor{
    private String apikey = "JF1qhvY5Ud1ZkiAvIsiFYExMh5dmOa7E";

    public Map<String,String> getSupportedUnits()  {
        Map<String, String> currenciesMap = new HashMap<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
        .url("https://api.apilayer.com/currency_data/list")
        .addHeader("apikey", apikey)
        .method("GET", null)
        .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (Exception e) {
            return null;
        }
        try {
            JSONObject currenciesJson = new JSONObject(response.body().string());
            if (!currenciesJson.getBoolean("success")) {
                return currenciesMap;
            }
            org.json.JSONArray currenciesArray = currenciesJson.getJSONObject("currencies").names();
            for (int i = 0; i < currenciesArray.length(); i++) {
                String code = currenciesArray.getString(i);
                String name = currenciesJson.getJSONObject("currencies").getString(code);
                currenciesMap.put(code, name);
            }

        } catch (Exception e) {
            return null;
        }
        return currenciesMap;
    }

    public double getconvert(String to, String from, double amount){
        double result = -1;
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
        .url("https://api.apilayer.com/currency_data/convert?to="+to+"&from="+from+"&amount="+amount+"")
        .addHeader("apikey", apikey)
        .method("GET", null)
        .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (Exception e) {
            return result;
        }

        try {
            JSONObject currenciesJson = new JSONObject(response.body().string());
            if (!currenciesJson.getBoolean("success")) {
                return -1;
            }
            result = currenciesJson.getDouble("result");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
