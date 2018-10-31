package com.example.hima.earthquake.DataFeature;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Key;
import java.util.ArrayList;

public class JsonParse {

    ArrayList<Properties> properties;

    public ArrayList<Properties> JsonProcess(String JsonFile)
    {
        properties = new  ArrayList<Properties>();

        try {
            JSONObject objectFile = new JSONObject(JsonFile);
            JSONArray featureArray = objectFile.getJSONArray("features");
            for (int i =0 ; i<featureArray.length();i++)
            {
                JSONObject currentEarthquake  = featureArray.getJSONObject(i);
                JSONObject propertiesObject = currentEarthquake.getJSONObject("properties");
                Properties p = new Properties(
                        propertiesObject.getDouble(KeyValue.mag),
                        propertiesObject.getString(KeyValue.location),
                        propertiesObject.getLong(KeyValue.time),
                        propertiesObject.getString(KeyValue.url));

                properties.add(p);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  properties;
    }

    public ArrayList<Properties> getProperties() {
        return getProperties();
    }
}
