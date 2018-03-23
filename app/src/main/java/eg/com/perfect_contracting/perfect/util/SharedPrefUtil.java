package eg.com.perfect_contracting.perfect.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by java on 01/12/2017.
 */

public class SharedPrefUtil {

   public static void savedInShared(Context mContext , boolean Islogin){
       SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
       prefs.edit().putBoolean("Islogin", Islogin).commit();
   }

    public static boolean isSavedInShared(Context mContext){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
         prefs.getBoolean("Islogin", false);
        return true;

    }


}
