package com.example.aml.gittext.activity;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
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
 * 456
 */
public class MainActivity extends AppCompatActivity {
    WebSocketClient mWebSocketClient = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        try {
            mWebSocketClient = new WebSocketClient(new URI("ws://7p79u2.natappfree.cc/websocket")) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    Log.d("~", "已经连接");
                    String message =serverHandshake.getHttpStatusMessage();
                    Log.d("~", message);
                    mWebSocketClient.send("okok，好");
                }
                @Override
                public void onMessage(String s) {
                    Log.d("~", "payload = " + s);
                }
                @Override
                public void onClose(int i, String s, boolean b) {
                    Log.d("~", "已经关闭" + i + s);
                }
                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mWebSocketClient.connect();
//        try {
//
//            webSocket.connect("ws://7p79u2.natappfree.cc/websocket", new WebSocketHandler() {
//                @Override
//                public void onOpen() {
//                    super.onOpen();
//                    Log.d("~", "已经连接");
//                }
//
//                @Override
//                public void onBinaryMessage(byte[] payload) {
//                    super.onBinaryMessage(payload);
//                }
//
//                @Override
//                public void onClose(int code, String reason) {
//                    super.onClose(code, reason);
//
//
//                    Log.d("~", "已经关闭" + code + reason);
//                }
//
//                @Override
//                public void onTextMessage(String payload) {
//                    super.onTextMessage(payload);
//                    Log.d("~", "payload = " + payload);
//                }
//
//                @Override
//                public void onRawTextMessage(byte[] payload) {
//                    super.onRawTextMessage(payload);
//                }
//            });
//        } catch (WebSocketException e) {
//            e.printStackTrace();
//        }
//        final AsyncTaskLoader loader = new AsyncTaskLoader(this) {
//            @Override
//            public Object loadInBackground() {
//
//                return "dsf";
//            }
//        };
//        getLoaderManager().initLoader(1, null, new LoaderManager.LoaderCallbacks<String>() {
//            @Override
//            public Loader<String> onCreateLoader(int i, Bundle bundle) {
//                return loader;
//            }
//
//            @Override
//            public void onLoadFinished(Loader<String> loader, String s) {
//
//            }
//
//            @Override
//            public void onLoaderReset(Loader<String> loader) {
//
//            }
//        }).forceLoad();


        TextView textView = findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                webSocket.sendTextMessage("亲爱的服务器你好");
//                webSocket.disconnect();
//                mWebSocketClient.send("服务器你好，嘿嘿！");
                mWebSocketClient.getConnection().send("服务器你好，嘿嘿！");
            }
        });

//        webSocket.connect("ws://115.159.78.127:8080/noticecontroller/info", object : WebSocketHandler() {
//            override fun onOpen() {
//                super.onOpen()
//                System.out.println("已经连接")
//            }
//
//            override fun onClose(code: Int, reason: String?) {
//                super.onClose(code, reason)
//                System.out.println("已经关闭")
//
//            }
//
//            override fun onBinaryMessage(payload: ByteArray?) {
//                super.onBinaryMessage(payload)
//                System.out.println("已经关闭")
//
//            }
//
//            override fun onRawTextMessage(payload: ByteArray?) {
//                super.onRawTextMessage(payload)
//            }
//
//            override fun onTextMessage(payload: String?) {
//                super.onTextMessage(payload)
//            }
//        })
    }


}
