package com.example.hima.earthquake.DataFeature;

import java.util.Date;

public class Properties {
    public final double Magnitude;
    public final String Location;
    public final long TimeInMilliseconds;
    public final String Url;

    public Properties(double Magnitude, String Location, long TimeInMilliseconds, String Url) {
        this.Magnitude = Magnitude;
        this.Location = Location;
        this.TimeInMilliseconds = TimeInMilliseconds;
        this.Url = Url;
    }

    public double getMagnitude() {
        return Magnitude;
    }

    public String getLocation() {
        return Location;
    }

    public Long getTimeInMilliseconds() {
        return TimeInMilliseconds;
    }

    public String getUrl() {
        return Url;
    }

}
