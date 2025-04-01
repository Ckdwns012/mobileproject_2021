package com.jshan.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class sickActivity extends AppCompatActivity {
    TextView diseasetext;
    ImageButton yes1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sick1);

        //확인 버튼 클릭시 증상 선택 화면으로 돌아가기
        yes1=findViewById(R.id.yes1);
        yes1.setClickable(true);
        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(sickActivity.this,ifsickActivity.class);
                startActivity(intent);
            }
        });

        //증상별 진단 가져오기
        diseasetext=findViewById(R.id.diseasetext);
        Intent intent =getIntent();
        Bundle bundle1 = intent.getExtras();
        Bundle bundle2 = intent.getExtras();
        Bundle bundle3 = intent.getExtras();
        Bundle bundle4 = intent.getExtras();
        Bundle bundle5 = intent.getExtras();

        // 선택되지 않았다면 아무것도 출력하지 않기
        String str1= bundle1.getString("sick1");
        if (str1==null){
            str1="";
        }
        String str2= bundle2.getString("sick2");
        if (str2==null){
            str2="";
        }
        String str3= bundle3.getString("sick3");
        if (str3==null){
            str3="";
        }
        String str4= bundle4.getString("sick4");
        if (str4==null){
            str4="";
        }
        String str5= bundle5.getString("sick5");
        if (str5==null){
            str5="";
        }
        String sick = str1+str2+str3+str4+str5;
        diseasetext.setText(sick);



    }
}