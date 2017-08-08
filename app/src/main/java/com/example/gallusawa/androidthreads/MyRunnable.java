package com.example.gallusawa.androidthreads;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by gallusawa on 8/8/17.
 */

public class MyRunnable extends Thread {

    Handler handler = new Handler(Looper.getMainLooper());
    TextView textView;
    int i;

    public MyRunnable(TextView textView) {
        this.textView = textView;
    }

    public void run() {
        System.out.println();
        for (i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.postDelayed(new java.lang.Runnable() {
                @Override
                public void run() {
                    textView.setText(String.valueOf(i));
                }
            }, 2000);

        }
    }
}