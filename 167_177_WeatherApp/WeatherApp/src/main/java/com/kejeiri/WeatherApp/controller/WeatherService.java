package com.kejeiri.WeatherApp.controller;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    private final String API ="f79dd571379f3d16755b83bddec8818d";
    private static String units;
    private String url;
    private String city;
    private JSONObject jsonObject;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private OkHttpClient client;

    WeatherService(){
        WeatherService.units="metric";

    }
    public JSONObject getWeather() throws IOException {
       this.url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&units="+units+"&APPID="+API;
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
            Response response = client.newCall(request).execute();
        this.jsonObject = new JSONObject(response.body().string());
        return getJsonObject();
    }

    /*public JSONArray getWeatherArray()  throws IOException{
       return jsonObject.getJSONArray("weather");
    }*/

    public JSONObject getMainSection() throws IOException {
        return jsonObject.getJSONObject("main");
    }

    public JSONObject getWindSection() throws IOException {
        return jsonObject.getJSONObject("wind");
    }
    public JSONObject getSysSection() throws IOException {
        return jsonObject.getJSONObject("sys");
    }

    public String getImgUrl(String icon) {
        return "http://openweathermap.org/img/w/"+icon+".png";
    }

    public void setUnits(String units) {
        this.units=units;
    }
}
