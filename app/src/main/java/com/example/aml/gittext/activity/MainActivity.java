package com.example.aml.gittext.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.aml.gittext.R;

import java.net.HttpURLConnection;

/**
 * 使用ViewDragHolper实现侧滑
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.findFragmentById(R.id.id_container_menu);
        manager.beginTransaction().add(R.id.id_container_menu, new MenuFragment()).commit();
    }

}
