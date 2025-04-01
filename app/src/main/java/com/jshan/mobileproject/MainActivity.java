package com.jshan.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ImageButton main_recording;
    ImageButton main_result;
    ImageButton main_choice;
    ImageButton main_sick;
    Button btn_music_start, btn_music_stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), myservice.class);
        startService(intent); // 메인 액티비티 실행시

        // 기록하기 엑티비티로 넘어가기
        main_recording=findViewById(R.id.main_recording);
        main_recording.setClickable(true);
        main_recording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,afterecord1Activity.class);
                startActivity(intent);
            }
        });

        // 음주 달력 보기 엑티비티로 넘어가기
        main_result=findViewById(R.id.main_result);
        main_result.setClickable(true);
        main_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,savedataActivity.class);
                startActivity(intent);
            }
        });

        // 해장이의 선택 엑티비티로 넘어가기
        main_choice=findViewById(R.id.main_choice);
        main_choice.setClickable(true);
        main_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,recomendActivity.class);
                startActivity(intent);
            }
        });

        // 몸이 안좋다면? 엑티비티로 넘어가기
        main_sick=findViewById(R.id.main_sick);
        main_sick.setClickable(true);
        main_sick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ifsickActivity.class);
                startActivity(intent);
            }
        });

    }

    //옵션 메뉴를 사용해 BGM ON/OFF
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitem, menu);
        return true;
    }
}
