package podcast.com.br.podtche.utils;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;


/**
 * Created by gholz on 5/18/16.
 */
public class SimpleLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
//            ProfileManager.getInstance().setLocation(location);
//            OffersManager.getInstance().refresh(true);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
