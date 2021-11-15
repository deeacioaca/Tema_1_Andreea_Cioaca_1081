package com.example.tema_dam_andreea_cioaca_1081;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String urlPath, IResponse response) {
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            Log.v("rezultat", result.toString());

            reader.close();
            inputStreamReader.close();
            inputStream.close();

            List<TrackingCategory> list = parsare(result.toString());

            response.onSuccess(list);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
    }

    private List<TrackingCategory> parsare(String jsonString) {
        List<TrackingCategory> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray array = jsonObject.getJSONArray("categories");
            for (int i = 0; i < array.length(); i++) {
                JSONObject currentObject = array.getJSONObject(i);
                String categoryName = currentObject.getString("categoryName");
                String symptom1 = currentObject.getString("symptom1");
                String symptom2 = currentObject.getString("symptom2");
                String symptom3 = currentObject.getString("symptom3");
                TrackingCategory category = new TrackingCategory(categoryName, symptom1, symptom2, symptom3);
                list.add(category);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
