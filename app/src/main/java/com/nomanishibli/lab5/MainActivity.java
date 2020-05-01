package com.nomanishibli.lab5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainActivity extends AppCompatActivity {

    private static final String STORAGE_KEY = "activityCounts";
    private Gson mGson = new GsonBuilder().create();

    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    private int[] counts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShared = getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE);
        mEditor = mShared.edit();
        counts = mGson.fromJson(mShared.getString(STORAGE_KEY, "[0, 0, 0, 0, 0, 0, 0]"), int[].class);
        TextView t_oncreate = findViewById(R.id.tv_oncreate);
        TextView t_onpause = findViewById(R.id.tv_onpause);
        TextView t_onstop = findViewById(R.id.tv_onstop);
        TextView t_onrestart = findViewById(R.id.tv_onrestart);
        TextView t_ondestroy = findViewById(R.id.tv_ondestroy);

        counts[0]++;

        t_oncreate.setText("onCreate: " + counts[0]);
        t_onpause.setText("onPause: " + counts[3]);
        t_onstop.setText("onStop: " + counts[4]);
        t_onrestart.setText("onRestart: " + counts[5]);
        t_ondestroy.setText("onDestroy: " + counts[6]);

        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
    }


    @Override
    protected void onStart() {
        super.onStart();
        TextView t_onStart = findViewById(R.id.tv_onstart);

        counts[1]++;

        t_onStart.setText("onStart: " + counts[1]);

        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView t_onResume = findViewById(R.id.tv_onresume);

        counts[2]++;

        t_onResume.setText("onResume: " + counts[2]);

        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView t_onPause = findViewById(R.id.tv_onpause);

        counts[3]++;

        t_onPause.setText("onPause: " + counts[3]);

        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        TextView t_onStop = findViewById(R.id.tv_onstop);

        counts[4]++;

        t_onStop.setText("onResume: " + counts[4]);

        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        TextView t_onRestart = findViewById(R.id.tv_onrestart);

        counts[5]++;

        t_onRestart.setText("onRestart: " + counts[5]);

        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();
    }

    @Override
    protected void onDestroy() {
        TextView t_onDestroy = findViewById(R.id.tv_ondestroy);

        counts[6]++;

        t_onDestroy.setText("onDestroy: " + counts[6]);

        mEditor.putString(STORAGE_KEY, mGson.toJson(counts));
        mEditor.apply();

        super.onDestroy();
    }

}
