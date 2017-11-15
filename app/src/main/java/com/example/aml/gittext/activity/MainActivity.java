package com.example.aml.gittext.activity;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.aml.gittext.R;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;

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
            }
        });


    }


}
