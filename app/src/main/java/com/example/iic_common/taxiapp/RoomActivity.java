package com.example.iic_common.taxiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by iic_common on 2018-07-12.
 */

public class RoomActivity extends Activity{
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        Button prv;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room);
        setTitle("?");

        Intent inIntent = getIntent();
        //temp = inIntent.getStringExtra("as",0);
        prv=(Button)findViewById(R.id.prv);
        prv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

             finish();
            }
        });
    }
}
