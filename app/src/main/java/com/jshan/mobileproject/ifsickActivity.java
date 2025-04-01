package com.jshan.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class ifsickActivity extends AppCompatActivity {
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    ImageButton yes2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ifsick);
        // 확인버튼 클릭시 메인 엑티비티로 돌아가기
        yes2=findViewById(R.id.yes2);
        yes2.setClickable(true);
        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ifsickActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        // 증상별 버튼 선택시 sick 엑티비티에 값 전달

        bt1=findViewById(R.id.bt1);
        bt1.setClickable(true);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ifsickActivity.this,sickActivity.class);
                intent.putExtra("sick1"," 소화기 질환을 의심해 봐요!\n" +
                        "\n" +
                        "음주는 일차적으로 소화기에 타격을 가하는데, 타격 강도에 따라 단순 속 불편함을 넘어 식도열상, 역류성 식도염, 위염, 위궤양, 십이지장 궤양, 장염 등으로 나타날 수 있어요.");
                startActivity(intent);
            }
        });

        bt2=findViewById(R.id.bt2);
        bt2.setClickable(true);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ifsickActivity.this,sickActivity.class);
                intent.putExtra("sick2","알콜성 치매를 의심해봐요!\n\n"+"전문가들은 적정음주도 오랜 기간 지속하면 뇌 용적을 감소시키며 이런 뇌위축이 우울증, 불면증, 치매 등을 유발할 수 있다고 지적해요. 젊은 층에서 치매가 발생하는 이유도 술로 인한 알코올성 치매가 주원인이라고 해요.");
                startActivity(intent);
            }
        });

        bt3=findViewById(R.id.bt3);
        bt3.setClickable(true);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ifsickActivity.this,sickActivity.class);
                intent.putExtra("sick3","우울증을 의심해봐요!\n" +
                        "\n" +
                        "우울함을 술로 달래는 경우가 있는데, 알코올의 독성이 뇌세포 파괴를 촉진시켜 불면증, 불안, 우울증, 의욕저하, 짜증 등을 유발하기 때문이에요. 우울증과 알코올사용장애가 동반되는 경우 치료반응이 좋지 않고 자살위험이 3배 이상 급증한다는 연구결과도 있어 주의가 필요해요!");
                startActivity(intent);
            }
        });

        bt4=findViewById(R.id.bt4);
        bt4.setClickable(true);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ifsickActivity.this,sickActivity.class);
                intent.putExtra("sick4","통풍을 의심해봐요!\n" +
                        "\n" +
                        "손, 발 등 말단 부위에 발생해 바람에 스치기만 해도 극심한 통증이 유발되는 통풍. 통풍은 혈중 요산 수치가 높아져 생기는 질환인데 술은 이 요산을 증가시켜 통풍을 유발하거나 악화시킬 수 있어요.");
                startActivity(intent);
            }
        });

        bt5=findViewById(R.id.bt5);
        bt5.setClickable(true);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ifsickActivity.this,sickActivity.class);
                intent.putExtra("sick5","빈혈을 의심해봐요!\n" +
                        "\n" +
                        "술은 철분, 비타민 등 헤모글로빈을 만드는 성분들의 흡수를 방해하고 산소 요구량을 증가시키며 골수의 생산능력을 저하시켜 조혈세포 수를 감소시켜 빈혈을 유발할 수 있어요. 나른함, 피로, 현기증, 구역질, 변비 등의 증상이 있다면 빈혈을 의심해볼 수 있어요.\n" );
                startActivity(intent);
            }
        });
    }
}

