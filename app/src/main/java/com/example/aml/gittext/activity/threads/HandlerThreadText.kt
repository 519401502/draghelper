package com.example.aml.gittext.activity.threads

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log

/**
 * Created by 18624915319 on 2017/11/15.
 */
class HandlerThreadText : Handler {

    constructor(looper : Looper) : super(looper)

    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)
        when(msg?.what){
            1 -> {
                Log.d("~", "这是在子线程发出的消息")
            }
        }
    }

}