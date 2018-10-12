package com.example.iic_common.taxiapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by iic_common on 2018-07-05.
 */

public class SendActivity extends AppCompatActivity {
    EditText t_start, t_end, t_sex;
    String buf1, buf2, buf3;
    int people;
    Button b_sex;
    LinearLayout baseLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        setTitle("Taxi");
        Button b_start = (Button) findViewById(R.id.b_start);
        baseLayout=(LinearLayout)findViewById(R.id.baseLayout);
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
                        if (end[i] == buf1) {
                            buf2 = "\0";
                            Toast.makeText(getApplicationContext(), "출발지와 목적지가 같습니다", Toast.LENGTH_LONG).show();
                        } else {
                            buf2 = end[i];
                        }
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

        Button call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(SendActivity.this);
                dlg.setTitle("확인");
                dlg.setMessage("출발지 : " + buf1 + "\n" + "도착지 : " + buf2 + "\n" + "방종류 : " + buf3);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "호출하였습니다", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), RoomActivity.class);
                        intent.putExtra("Num1",
                                Integer.parseInt(t_start.getText().toString()));
                        intent.putExtra("Num2",
                                Integer.parseInt(t_end.getText().toString()));
                        startActivityForResult(intent,0);
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
        b_sex = (Button) findViewById(R.id.b_sex);
        registerForContextMenu(b_sex);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == b_sex) {
            menu.setHeaderTitle("방종류");
            menu.add(0, 1, 0, "남");
            menu.add(0, 2, 0, "여");
            menu.add(0, 3, 0, "남/여");
        }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                t_sex = (EditText) findViewById(R.id.t_sex);
                t_sex.setText("남");
                buf3 = "남";
                return true;
            case 2:

                t_sex = (EditText) findViewById(R.id.t_sex);
                t_sex.setText("여");
                buf3 = "여";
                return true;

            case 3:

                t_sex = (EditText) findViewById(R.id.t_sex);
                t_sex.setText("남/여");
                buf3 = "남/여";
                return true;

        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);
        // return super.onCreateOptionsMenu(menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.lost:
                Toast.makeText(getApplicationContext(), "취소하였습니다", Toast.LENGTH_LONG).show();

                return true;
            case R.id.board:
                Toast.makeText(getApplicationContext(), "취소하였습니다", Toast.LENGTH_LONG).show();

                return true;
            case R.id.logout:
                AlertDialog.Builder dlg = new AlertDialog.Builder(SendActivity.this);
                dlg.setTitle("로그아웃 하시겠습니까?");

                dlg.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "취소하였습니다", Toast.LENGTH_LONG).show();
                    }
                });
                dlg.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "로그아웃합니다", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                dlg.show();
                return true;
        }
        return false;
    }


}
