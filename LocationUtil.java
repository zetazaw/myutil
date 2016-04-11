package com.iscistech.mobile.machinestradersdemo.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by User on 4/8/2016.
 */
public class LocationUtil {

    public static Location getLocation(Context context) {
        LocationManager locationManager;
        //String bestProvider;
        locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
        //Criteria criteria = new Criteria();
        //bestProvider = locationManager.getBestProvider(criteria, false);
        //Log.d("xxx", bestProvider);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d("xxx", "Permission conflict");
            return null;
        }
        return locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);

    }

    public static String getCountryName(Context context, Location location) {
        double latitude, longitude;
        if (location != null){

            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }else {
            return null;
        }

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            //Address result;

            if (addresses != null && !addresses.isEmpty()) {
                return addresses.get(0).getCountryName();
            }

        } catch (IOException ignored) {
            //do something
            return ignored.getMessage();

        }
        return null;
    }
}
