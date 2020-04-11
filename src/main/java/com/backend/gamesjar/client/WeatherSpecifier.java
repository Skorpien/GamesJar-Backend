package com.backend.gamesjar.client;

import com.backend.gamesjar.domain.WeatherDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WeatherSpecifier {

    public WeatherDto specificResult(WeatherDto weatherDto, String strUrl) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(strUrl);
            URLConnection con = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            //Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

            weatherDto.setTemp(mainMap.get("temp").toString());
            weatherDto.setHumidity(mainMap.get("humidity").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherDto;
    }


    public Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }
}
