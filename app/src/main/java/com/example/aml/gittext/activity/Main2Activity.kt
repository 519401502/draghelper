package com.example.aml.gittext.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.FileObserver
import android.os.HandlerThread
import android.support.v4.os.EnvironmentCompat
import android.util.Log
import com.example.aml.gittext.R
import com.example.aml.gittext.activity.threads.HandlerThreadText
import java.io.File

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val hanlderThread = HandlerThread(this.localClassName)
        hanlderThread.start()


        var aHandlerThread = HandlerThreadText(hanlderThread.looper)
        aHandlerThread.sendEmptyMessage(1)


        val file = Environment.getExternalStorageDirectory()
        val observer = MyFileObserver(file.path)
        observer.startWatching()
        Log.d("~", file.path)
        val fileSon = File(file.path + "/text.txt")
        if (!fileSon.exists())
            fileSon.createNewFile()
    }


    open class MyFileObserver : FileObserver {

        constructor(path: String) : super(path)

        override fun onEvent(p0: Int, p1: String?) {
            Log.d("~", p0.toString())

            val event: Int = p0 and FileObserver.ALL_EVENTS

            when(event){
                FileObserver.OPEN -> {
                    Log.d("~", "open")

                    println("")
                }
                FileObserver.CREATE -> {
                    Log.d("~", "create")

                    println("create")
                }
                FileObserver.MODIFY -> {
                    Log.d("~", "modify")

                    println("modify")
                }
            }
        }



    }


}
