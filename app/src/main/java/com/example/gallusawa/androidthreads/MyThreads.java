package com.example.gallusawa.androidthreads;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by gallusawa on 8/8/17.
 */

public class MyThreads extends Thread {

    Handler handler = new Handler(Looper.getMainLooper());
    TextView tvTesting;
    int i;

    public MyThreads(TextView tvTesting ){

        this.tvTesting = tvTesting;

    }

    @Override
    public void run() {
        super.run();
        for ( i = 0; i < 10; i++) {

            try {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvTesting.setText(String.valueOf(i));
                    }
                });


                Thread.sleep(1000);
                System.out.println();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EventBus.getDefault().post(new MessageEvent(String.valueOf(i)));
        }


    }
}
