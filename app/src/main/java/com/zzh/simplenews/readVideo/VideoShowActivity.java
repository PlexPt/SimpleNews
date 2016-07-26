package com.zzh.simplenews.readVideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.zzh.simplenews.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by zzh on 16/7/22.
 */
public class VideoShowActivity extends AppCompatActivity {
    private View decorView;
    private VideoView mVideoView;
    private String mUrl;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_show);
        decorView = getWindow().getDecorView();
        Vitamio.isInitialized(this);
        mVideoView = (VideoView) findViewById(R.id.video_view);
        mProgressBar = (ProgressBar)findViewById(R.id.video_progressBar);

        mUrl = getIntent().getStringExtra("url");
        mVideoView.setVideoPath(mUrl);
        mVideoView.setMediaController(new MediaController(this));
        //mVideoView.requestFocus();

        mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what){
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        mVideoView.pause();
                        mProgressBar.setVisibility(View.VISIBLE);
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        mVideoView.start();
                        mProgressBar.setVisibility(View.GONE);
                        break;
                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        break;
                }
                return true;
            }
        });


    }
    public static void newIntent(Activity activity, String url){
        Intent intent = new Intent(activity,VideoShowActivity.class);
        intent.putExtra("url",url);
        activity.startActivity(intent);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoView.stopPlayback();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
