package com.jshan.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class afterecord1Activity extends AppCompatActivity {
    ImageButton record;
    EditText input_soju,input_beer,input_wine,input_whiskey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterrecord1);

        input_soju=findViewById(R.id.count1);
        input_beer=findViewById(R.id.count2);
        input_wine=findViewById(R.id.count3);
        input_whiskey=findViewById(R.id.count4);

        record=findViewById(R.id.record);
        record.setClickable(true);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String soju = input_soju.getText().toString();
                String whiskey = input_whiskey.getText().toString();
                String beer = input_beer.getText().toString();
                String wine = input_wine.getText().toString();

                //빈값이 넘어올때의 처리
                if(soju.getBytes().length <= 0){
                    soju="0";
                }
                if(beer.getBytes().length <= 0){
                    beer="0";
                }
                if(wine.getBytes().length <= 0){
                    wine="0";
                }
                if(whiskey.getBytes().length <= 0){
                    whiskey="0";
                }

                // 입력값이 모두 빈값일때의 처리
                if (soju=="0" && beer=="0" && wine=="0" && whiskey=="0"){
                    Toast.makeText(getApplicationContext(), "음주량을 입력해주세요", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(afterecord1Activity.this, savedataActivity.class);
                    intent.putExtra("soju",soju);
                    intent.putExtra("beer",beer);
                    intent.putExtra("wine",wine);
                    intent.putExtra("whiskey",whiskey);
                    startActivity(intent);
                }
            }
        });


    }
}