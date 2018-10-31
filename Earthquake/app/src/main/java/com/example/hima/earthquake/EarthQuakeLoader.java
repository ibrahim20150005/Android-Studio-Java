package com.example.hima.earthquake;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.hima.earthquake.DataFeature.HttpHandler;
import com.example.hima.earthquake.DataFeature.JsonParse;
import com.example.hima.earthquake.DataFeature.Properties;

public class EarthQuakeLoader  extends AsyncTaskLoader<List<Properties>> {
    private String Url;
    JsonParse parse = new JsonParse();
    HttpHandler handler = new HttpHandler();
    public EarthQuakeLoader(Context context,String url) {
        super(context);
        this.Url=url;
    }

    @Override
    public List<Properties> loadInBackground() {
        List<Properties> properties = null;
        try {
            properties = parse.JsonProcess(handler.execute(Url).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
