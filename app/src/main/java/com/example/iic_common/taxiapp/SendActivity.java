package com.example.iic_common.taxiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by iic_common on 2018-07-05.
 */

public class SendActivity extends AppCompatActivity {
    EditText t_start, t_end;
    View v_start;
    String buf1, buf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        setTitle("Taxi");
        final Button b_start = (Button) findViewById(R.id.b_start);


        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] start = new String[]{"강대정문", "강대쪽문", "강대후문", "남춘천역"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(SendActivity.this);
                dlg.setTitle("출발지");
                dlg.setSingleChoiceItems(start, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        buf1 = start[i];
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        t_start = (EditText) findViewById(R.id.t_start);
                        t_start.setText(buf1);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        buf1 = "\0";
                    }
                });
                dlg.show();
            }
        });

        final Button b_end = (Button) findViewById(R.id.b_end);
        b_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] end = new String[]{"강대정문", "강대쪽문", "강대후문", "남춘천역"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(SendActivity.this);
                dlg.setTitle("도착지");
                dlg.setSingleChoiceItems(end, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        buf2 = end[i];
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        t_end = (EditText) findViewById(R.id.t_end);
                        //if(strcmp())
                        t_end.setText(buf2);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        buf2 = "\0";
                    }
                });
                dlg.show();
            }
        });
        Button b_people = (Button) findViewById(R.id.b_people);
        b_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SendActivity.this);
                dlg.setTitle("인원수");
                dlg.setPositiveButton("확인", null);
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        Button b_time = (Button) findViewById(R.id.b_time);
        b_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SendActivity.this);
                dlg.setTitle("시간");
                dlg.setPositiveButton("확인", null);
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        Button call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SendActivity.this);
                dlg.setTitle("확인");
                dlg.setMessage("출발지 : " + buf1+"\n"+"도착지 : " + buf2) ;
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "호출하였습니다", Toast.LENGTH_LONG).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소하였습니다", Toast.LENGTH_LONG).show();
                    }
                });
                dlg.show();
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
