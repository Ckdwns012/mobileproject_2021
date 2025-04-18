package com.jshan.mobileproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class myservice extends Service {

    MediaPlayer mediaPlayer; //음악 재생을 위한 객체

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //Service객체와 Activity사이에서 통신을 할 때 사용되는 메서드
        //데이터 전달이 필요 없으면 null
        return null;
    }

    @Override
    public void onCreate() {
        //서비스에서 가장 먼저 호출(최초한번)
        mediaPlayer = MediaPlayer.create(this, R.raw.test2);
        mediaPlayer.setLooping(true); // 반복재생
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //서비스가 실행될 때 실행
        mediaPlayer.start(); //음악 시작
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //서비스가 종료될 때 실행
        mediaPlayer.stop(); //음악 종료
        super.onDestroy();
    }
}