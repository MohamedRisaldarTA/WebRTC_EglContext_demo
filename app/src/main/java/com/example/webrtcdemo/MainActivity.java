package com.example.webrtcdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.GlRectDrawer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<EglRenderer> renders = new ArrayList<>();;
    @Override
    protected void onResume() {
        super.onResume();
        for(int i=0;i<100;i++) {
          createPlayer(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    void createPlayer(int i) {
                EglRenderer renderer = new EglRenderer(String.valueOf(i));
                SurfaceTexture surfaceTexture = new SurfaceTexture(i);
                renderer.init(EglUtils.getRootEglBaseContext(),EglBase.CONFIG_PLAIN,new GlRectDrawer() );
                renderer.createEglSurface(surfaceTexture);
                renders.add(renderer);
    }
}