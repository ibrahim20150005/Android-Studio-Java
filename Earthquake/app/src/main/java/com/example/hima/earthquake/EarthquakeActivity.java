package com.example.hima.earthquake;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hima.earthquake.DataFeature.HttpHandler;
import com.example.hima.earthquake.DataFeature.JsonParse;
import com.example.hima.earthquake.DataFeature.Properties;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Properties>> {

    private  static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
    JsonParse jsonParse = new JsonParse();
    HttpHandler handler = new HttpHandler();
    RecyclerView recyclerView;
    AdapterForRecycleView adapter;
    ArrayList<Properties> arrayOfData;
    LoaderManager loaderManager = getLoaderManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);
        recyclerView = findViewById(R.id.recycleView);

        try {
            arrayOfData = jsonParse.JsonProcess(handler.execute(USGS_REQUEST_URL).get());
           loaderManager.initLoader(0,null,this);
            adapter = new AdapterForRecycleView(this,arrayOfData);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Loader<List<Properties>> onCreateLoader(int id, Bundle args) {
        return new EarthQuakeLoader(EarthquakeActivity.this,USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Properties>> loader, List<Properties> data) {

        arrayOfData.clear();
        if (data != null && !data.isEmpty()) {
            arrayOfData.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Properties>> loader) {

        arrayOfData.clear();
    }
}
