package com.example.haniel.magicball;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_text;

    String[] text;

    Random r;

    MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reproductor = MediaPlayer.create(this,R.raw.musicamisterio);
        reproductor.setLooping(true);
        reproductor.start();

        r = new Random();

        tv_text = (TextView) findViewById(R.id.tv_text);

        text = getResources().getStringArray(R.array.text);

        tv_text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv_text.setText(text[r.nextInt(20)]);
            }

        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if  (reproductor.isPlaying())
        {
            reproductor.stop();
            reproductor.release();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        reproductor.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        reproductor.pause();
    }
}
