package com.example.gallusawa.androidthreads;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tvTesting);
    }


    public void executeThreads(View view) {

        switch (view.getId()) {
            case R.id.btnthreads:
                MyThreads threads = new MyThreads(textView);
                threads.start();

                break;
            case R.id.btnrunnable:
                MyRunnable runnable = new MyRunnable(textView);
                Thread thread = new Thread(runnable);
                thread.start();
                break;
            case R.id.btnAsyntask:
                TestASynctask testASynctask = new TestASynctask();


        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        Toast.makeText(this, messageEvent.getMessage(),
                Toast.LENGTH_SHORT).show();
    }
}