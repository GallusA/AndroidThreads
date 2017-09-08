package com.example.gallusawa.androidthreads;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by gallusawa on 8/8/17.
 */

public class TestASynctask extends AsyncTask<String, Integer, String> {

    private static final String TAG = "Asynctask";
    @Override
    protected String doInBackground(String... string){

        Log.d(TAG, "doInBackground: " + string[0] + Thread.currentThread());
        publishProgress(1);
        return "result";

    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.d(TAG, "onPreExecute: "+ Thread.currentThread());

    }



}
