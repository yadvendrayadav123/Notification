package com.example.notification;

import android.app.Notification;
import android.content.Context ;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.NotificationListenerService ;
import android.service.notification.StatusBarNotification ;
import android.util.Log ;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationService extends NotificationListenerService{
    private String TAG = this .getClass().getSimpleName() ;
    Context context ;
    static MyListener myListener ;
    @Override
    public void onCreate () {
        super .onCreate() ;
        context = getApplicationContext() ;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onNotificationPosted (StatusBarNotification sbn) {
        Log. i ( TAG , "********** onNotificationPosted" ) ;
        Log.i(TAG, "onNotificationPosted: "+sbn.getNotification());
        Log. i ( TAG , "ID :" + sbn.getId()+ " \t " + sbn.getNotification(). tickerText + " \t " + sbn.getPackageName()) ;
        Notification notification = sbn.getNotification();
        Bundle bundle = notification.extras;
        String text = "";
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                Log.e(TAG, key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
            }
            text = (bundle.get("android.title")) +" " +(bundle.get("android.text"));
        }
        Log.i(TAG, "onNotificationPosted: "+text);
//        myListener .setValue( "Post: " + sbn.getPackageName()) ;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onNotificationRemoved (StatusBarNotification sbn) {
        Log. i ( TAG , "********** onNotificationRemoved" ) ;
        Log. i ( TAG , "ID :" + sbn.getId() + " \t " + sbn.getNotification(). tickerText + " \t " + sbn.getPackageName()) ;
//        myListener .setValue( "Remove: " + sbn.getPackageName()) ;
    }
//    public void setListener (MyListener myListener) {
//        NotificationService. myListener = myListener ;
//    }
}

