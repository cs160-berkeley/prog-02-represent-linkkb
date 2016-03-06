package com.cs160.joleary.represent;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        TextView locationText = (TextView) findViewById(R.id.locText);

        Intent thisIntent = getIntent();
        Bundle b = thisIntent.getExtras();
        String locationType = b.getString("LOCATION_TYPE");
        String zipCode = b.getString("ZIP_CODE");
        if (locationType.equalsIgnoreCase("current")) {
            locationText.setText(locationType);
        } else if (locationType.equalsIgnoreCase("Zip")) {
            locationText.setText(zipCode);
        }
    }

    public void onClick1(View v) {
        Intent activity3Intent = new Intent(getBaseContext(), Main3Activity.class);
        TextView name = (TextView) findViewById(R.id.rep1Name);
        activity3Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity3Intent.putExtra("REP_NAME", name.getText());
        startActivity(activity3Intent);
    };

    public void onClick2(View v) {
        Intent activity3Intent = new Intent(getBaseContext(), Main3Activity.class);
        TextView name = (TextView) findViewById(R.id.rep2Name);
        activity3Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity3Intent.putExtra("REP_NAME", name.getText());
        startActivity(activity3Intent);
    };

    public void onClick3(View v) {
        Intent activity3Intent = new Intent(getBaseContext(), Main3Activity.class);
        TextView name = (TextView) findViewById(R.id.rep3Name);
        activity3Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity3Intent.putExtra("REP_NAME", name.getText());
        startActivity(activity3Intent);
    };

}
