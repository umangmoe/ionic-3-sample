package io.ionic.starter;

import android.app.Application;
import com.moengage.cordova.MoECordova;
import com.moengage.core.Logger;
import com.moengage.core.MoEngage;

public class SampleApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    MoEngage moEngage =
        new MoEngage.Builder(this, "DAO6UGZ73D9RTK8B5W96TPYN")//enter your own app id
            .setLogLevel(Logger.VERBOSE)//enabling Logs for debugging
            .enableLogsForSignedBuild() //Make sure this is removed before apps are pushed to
            // production
            .setNotificationSmallIcon(
                R.mipmap.ic_launcher)//small icon should be flat, pictured face on, and must be
            // white
            // on a transparent background.
            .setNotificationLargeIcon(R.mipmap.ic_launcher)
            .enableLocationServices()//enabled To track location and run geo-fence campaigns
            .optOutTokenRegistration()// opting out since push configuration isn't done yet.
            .build();
    // initialize MoEngage SDK
    MoEngage.initialise(moEngage);
    // setup listener for JavaScript callback.
    MoECordova.registerNativeCallbacks();
  }
}