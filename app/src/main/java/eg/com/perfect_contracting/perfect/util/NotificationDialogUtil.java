package eg.com.perfect_contracting.perfect.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import eg.com.perfect_contracting.perfect.R;
import eg.com.perfect_contracting.perfect.ui.activities.SigninActivity;

/**
 * Created by java on 01/12/2017.
 */

public class NotificationDialogUtil {
    private static AlertDialog alert;

    public static void loginUserDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.must_login);
        builder.setCancelable(true);
        builder.setIcon(R.drawable.ic_person);
        builder.setMessage(context.getResources().getString(R.string.login_message));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.startActivity(new Intent(context, SigninActivity.class));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alert.dismiss();
            }
        });
         alert = builder.show();
    }
}
