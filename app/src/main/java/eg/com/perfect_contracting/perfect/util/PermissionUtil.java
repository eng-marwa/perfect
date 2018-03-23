package eg.com.perfect_contracting.perfect.util;


import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by MarwaTalaat on 4/28/2017.
 */

public class PermissionUtil {
    public static void checkPermission(AppCompatActivity activity, String[] permissions) {
        for (String permission : permissions) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (activity.checkSelfPermission(permission)!= PackageManager.PERMISSION_GRANTED){
                    activity.requestPermissions(permissions, 100);

                }

            }
        }
    }



}
