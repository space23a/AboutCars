package aboutcar.util.forwebs.com.aboutcars.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import aboutcar.util.forwebs.com.aboutcars.MainActivity;
import aboutcar.util.forwebs.com.aboutcars.R;

/**
 * Created by space on 2017-02-16.
 */

public class UtilCom {
    public static final String TAG = "Utils";

    // 네트워크 환경 체크
    public static boolean networkState(Context context) {
        try {
            NetworkInfo.State networkState = NetworkInfo.State.DISCONNECTED;
            ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (systemService != null && systemService.getActiveNetworkInfo() != null)
                networkState = systemService.getActiveNetworkInfo().getState();
            if (networkState == NetworkInfo.State.CONNECTED) {
                // 연결
                return true;
            } else {
                // 연결 실패
                Toast.makeText(context, R.string.noconnect, Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (Exception e) {
            Toast.makeText(context, "인터넷 연결 실패", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    // 권한 설정
    public static boolean permissionAgree(Activity act , String mode) {
        boolean flag = false;



        int permissionCheck = ContextCompat.checkSelfPermission(act, Manifest.permission.WRITE_CALENDAR);

        if(permissionCheck== PackageManager.PERMISSION_DENIED){
            // 권한 없음
            Toast.makeText(act , "권한 no " , Toast.LENGTH_SHORT).show();
        }else{
            // 권한 있음
            Toast.makeText(act , "권한 ok " , Toast.LENGTH_SHORT).show();
        }




        return flag;

    }


}
