package com.jshan.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Random;


public class recomendActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawerView;
    ImageButton randomchoice;
    ImageButton okay;
    ImageView randomimage;
    TextView recomend;
    Random ram = new Random();

    // 이미지와 텍스트 배열 순서대로 생성
    int[] img = {R.drawable.kongnamul, R.drawable.hamburger, R.drawable.coffee, R.drawable.ramen, R.drawable.myen,R.drawable.jambong,R.drawable.bbu,R.drawable.soon};
    String[] recomendarray=new String[]{"콩나물국","햄버거","커피","라면","냉면","짬뽕","뼈해장국","순대국"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recomend);

        // 어댑터를 사용한 리스트 뷰
        ListView list = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, recomendarray);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(),recomendarray[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });

        randomchoice=findViewById(R.id.randomchoice);
        okay=findViewById(R.id.okay);
        randomimage=findViewById(R.id.randomimage);
        recomend=findViewById(R.id.recomend);

        // 추천받기 선택시 랜덤으로 음식 추천 받기
        randomchoice.setClickable(true);
        randomchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = ram.nextInt(img.length);
                randomimage.setBackgroundResource(img[num]);
                recomend.setText(recomendarray[num]+" 어때?");
            }
        });

        // 확인버튼 클릭시 메인화면으로 돌아가기
        okay.setClickable(true);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(recomendActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //커스텀뷰를 통해 해장이의 추천메뉴 보여주기
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);
        Button btn_open = (Button) findViewById(R.id.btnopen);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close=(Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });
        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

    }
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}