package com.example.hima.earthquake.DataFeature;

import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpHandler extends AsyncTask<String,String,String> {

    URLConnection urlConnection = null;
    BufferedReader bufferedReader = null;
    String jsonFile = "";
    @Override
    protected String doInBackground(String... params)
    {
        URL url = createUrl(params[0]);
        jsonFile = makeHttpRequest(url);

        if (jsonFile == null)
        {
            return null;
        }
        return jsonFile;
    }
    private URL createUrl(String StringUrl)
    {
        URL url = null;
        try {
             url = new URL(StringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        return url;
    }
    private String makeHttpRequest(URL url)
    {
        if (url == null)
        {
            return jsonFile;
        }
        InputStream inputStream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            urlConnection = url.openConnection();
            inputStream = new BufferedInputStream(urlConnection.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while ((line = bufferedReader.readLine())!=null)
            {
                stringBuffer.append(line+"\n");
            }
            jsonFile = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonFile;
    }

}
