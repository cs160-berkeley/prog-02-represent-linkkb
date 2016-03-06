package com.cs160.joleary.represent;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.nio.charset.StandardCharsets;

/**
 * Created by joleary and noon on 2/19/16 at very late in the night. (early in the morning?)
 */
public class WatchListenerService extends WearableListenerService {
    // In PhoneToWatchService, we passed in a path, either "/FRED" or "/LEXY"
    // These paths serve to differentiate different phone-to-watch messages
    private static final String ZIP_LOCATION = "/Zip";
    private static final String CURRENT_LOCATION = "/Current";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in WatchListenerService, got: " + messageEvent.getPath());
        //use the 'path' field in sendmessage to differentiate use cases
        //(here, fred vs lexy)

        if( messageEvent.getPath().startsWith( ZIP_LOCATION ) ) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("LOCATION_TYPE", "Zip");
            intent.putExtra("ZIP_CODE",value.substring(4));
            Log.d("T", "about to start watch MainActivity with LOCATION_TYPE: Zip and zip code " + value);
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase( CURRENT_LOCATION )) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("LOCATION_TYPE", "Current");
            Log.d("T", "about to start watch MainActivity with LOCATION_TYPE: Current");
            startActivity(intent);
        } else {
            super.onMessageReceived( messageEvent );
        }

    }
}