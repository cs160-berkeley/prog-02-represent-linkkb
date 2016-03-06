package com.cs160.joleary.represent;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        TextView repName = (TextView) findViewById(R.id.repName);
        Intent thisIntent = getIntent();
        Bundle b = thisIntent.getExtras();
        String name = b.getString("REP_NAME");
        repName.setText(name);
    }

}
