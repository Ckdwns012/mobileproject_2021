package com.jshan.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class savedataActivity extends AppCompatActivity {
    DatePicker datePicker;  //  datePicker - 날짜를 선택하는 달력
    TextView viewDatePick;  //  viewDatePick - 선택한 날짜를 보여주는 textView
    EditText diary;   //  diary - 선택한 날짜의 일기를 쓰거나 기존에 저장된 음주가 있다면 보여주고 수정하는 영역
    Button savebtn;   //  savebtn - 선택한 날짜의 일기 저장 및 수정(덮어쓰기) 버튼
    String fileName;   //  fileName - 돌고 도는 선택된 날짜의 파일 이름

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 앱 첫 시작 시 돌아가는 메소드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savedata);

        // 뷰에 있는 위젯들 리턴 받아두기
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        viewDatePick = (TextView) findViewById(R.id.viewDatePick);
        diary = (EditText) findViewById(R.id.diary);
        savebtn = (Button) findViewById(R.id.savebtn);

        // 기록없이 달력으로 넘어갈때 생기는 오류 잡기
        try {
            Intent intent = getIntent();

            Bundle bundle = intent.getExtras();

            String soju,beer,wine,whiskey;
            soju = bundle.getString("soju");
            beer = bundle.getString("beer");
            wine = bundle.getString("wine");
            whiskey = bundle.getString("whiskey");

            // 오늘 날짜를 받게해주는 Calender
            Calendar c = Calendar.getInstance();
            int cYear = c.get(Calendar.YEAR);
            int cMonth = c.get(Calendar.MONTH);
            int cDay = c.get(Calendar.DAY_OF_MONTH);

            // 첫 시작 시에는 오늘 날짜 일기 읽어주기
            checkedDay(cYear, cMonth, cDay);
            diary.setText(" soju " + soju + " glass/ " +" beer " + beer + " glass\n " +" wine " + wine + " glass/ " +" whiskey " + whiskey+" glass"   );
            saveDiary(fileName);

        }catch (Exception exception){
            Calendar c = Calendar.getInstance();
            int cYear = c.get(Calendar.YEAR);
            int cMonth = c.get(Calendar.MONTH);
            int cDay = c.get(Calendar.DAY_OF_MONTH);
            checkedDay(cYear, cMonth, cDay);
        };


        // datePick 기능 만들기
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                checkedDay(year, monthOfYear, dayOfMonth);
            }
        });

        // 확인 버튼 누르면 실행되는 리스너
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDiary(fileName);
                Intent intent= new Intent(savedataActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // 음주 정보 파일 읽기
    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {

        // 선택한 날짜 보여주기
        viewDatePick.setText(year + " - " + (monthOfYear+1) + " - " + dayOfMonth);

        // 파일 이름 만들기
        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";

        // 음주 정보 가져오기
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);
            // 음주정보 데이터 바이트로 가져오기
            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();
            String str = new String(fileData, "EUC-KR");
            Toast.makeText(getApplicationContext(), "음주 있는 날", Toast.LENGTH_SHORT).show();
            diary.setText(str);

        //음주 정보가 없는 경우
        } catch (Exception e) { // UnsupportedEncodingException , FileNotFoundException , IOException
            Toast.makeText(getApplicationContext(), "음주 없는 날", Toast.LENGTH_SHORT).show();
            diary.setText("");
            e.printStackTrace();
        }
    }

    // 음주 정보 저장하기
    private void saveDiary(String readDay) {
        FileOutputStream fos = null;
        //private 모드로 파일 저장하기
        try {
            fos = openFileOutput(readDay, MODE_PRIVATE); //MODE_WORLD_WRITEABLE
            String content = diary.getText().toString();
            if (content.length()>0){
                fos.write(content.getBytes());
                fos.close();
            }
        //오류 발생 시 메인 엑티비티로 넘어가기
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "오류", Toast.LENGTH_SHORT).show();

            Intent intent= new Intent(savedataActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

}

