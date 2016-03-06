package com.cs160.joleary.represent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;
    private Button mRepBtn;
    private TextView mName;
    private LinearLayout mBG;
    private Button mSwipeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRepBtn = (Button) findViewById(R.id.rep_btn);
        mName = (TextView) findViewById(R.id.repName);
        mBG = (LinearLayout) findViewById(R.id.bg);
        mSwipeLeft = (Button) findViewById(R.id.swipeLeft);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String locationType = null;

        if (extras != null) {
            locationType = extras.getString("LOCATION_TYPE");
            if(locationType.equalsIgnoreCase("Zip")) {
                mRepBtn.setText("Using " + extras.getString("ZIP_CODE"));
                mRepBtn.setVisibility(View.VISIBLE);
                mBG.setBackgroundResource(R.drawable.boxer);
                mName.setText("Barbara Boxer");
                mName.setVisibility(View.VISIBLE);
            } else {
                mRepBtn.setText("Using " + locationType);
                mRepBtn.setVisibility(View.VISIBLE);
                mBG.setBackgroundResource(R.drawable.boxer);
                mName.setText("Barbara Boxer");
                mName.setVisibility(View.VISIBLE);
            }
        }

        final String location = locationType;

        mRepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(getBaseContext(), WatchToPhoneService.class);
                startService(sendIntent);
            }
        });

        mSwipeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getBaseContext(), Main2Activity.class);
                activity2Intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity2Intent.putExtra("LOCATION_TYPE",location);
                startActivity(activity2Intent);
            }
        });
    }

}
