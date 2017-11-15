package com.example.aml.gittext.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import android.util.Log
import com.example.aml.gittext.R
import com.example.aml.gittext.activity.threads.HandlerThreadText

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val hanlderThread = HandlerThread(this.localClassName)
        hanlderThread.start()


        var aHandlerThread = HandlerThreadText(hanlderThread.looper)
        aHandlerThread.sendEmptyMessage(1)

    }



}
