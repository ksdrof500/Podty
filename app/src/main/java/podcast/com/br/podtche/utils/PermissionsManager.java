package podcast.com.br.podtche.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by gholz on 3/13/16.
 */
public class PermissionsManager {

    public static final int LOCATION_PERMISSION_REQUEST_CODE = 100;

    public static boolean hasLocationPermission(Context context) {

        int fineLocationState = ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION);

        int coarseLocationState = ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        return fineLocationState == PackageManager.PERMISSION_GRANTED &&
                coarseLocationState == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestLocationPermission(Activity activity) {

        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };

        ActivityCompat.requestPermissions(activity, permissions, LOCATION_PERMISSION_REQUEST_CODE);
    }

    public static void requestSMSPermission(Activity activity) {
        if (!isPermissionGranted(activity, Manifest.permission.RECEIVE_SMS)) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    public static boolean isPermissionGranted(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }
}
