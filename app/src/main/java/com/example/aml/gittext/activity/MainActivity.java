package com.example.aml.gittext.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.aml.gittext.R;

import java.net.HttpURLConnection;

/**
 * 123
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text);
        assert textView == null;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                finish();
                Runtime runtime = Runtime.getRuntime();

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("~", "onStop");

    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d("~", "onTrimMemory");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("~", "onDestroy");
    }
}
