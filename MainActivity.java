package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        final MediaPlayer mediaPlayerBach;

        mediaPlayerBach = MediaPlayer.create(this, R.raw.bach);
        final Button play = (Button) findViewById(R.id.play);
        // Play
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();
                mediaPlayerBach.start();
                mediaPlayerBach.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MainActivity mediaPlayer) {
                        mediaPlayerBach.stop();
                        mediaPlayerBach.release();
                        Toast.makeText(getApplicationContext(), "Im Finished!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // Pause
        final Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Paused", Toast.LENGTH_SHORT).show();
                mediaPlayerBach.pause();
            }
        });
    }
}




