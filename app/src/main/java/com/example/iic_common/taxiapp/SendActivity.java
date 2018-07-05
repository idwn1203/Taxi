package com.example.iic_common.taxiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by iic_common on 2018-07-05.
 */

public class SendActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.send);
            Button logout = (Button)findViewById(R.id.start);
            logout.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                   finish();
                }
            });

    }
}
