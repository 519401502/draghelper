package com.example.aml.gittext

import android.os.FileObserver
import android.util.Log
import org.junit.Test
import java.io.File

/**
 * Created by 18624915319 on 2017/11/16.
 */
class FileText {

    @Test fun fileText() {

    }

    open class Textt {

        constructor(){
            println("构造函数")
        }

        fun text(): Unit {
            println("text方法")
        }

        init {
            println("init 方法")
        }
    }

    open class MyFileObserver : FileObserver {

        constructor(path: String) : super(path)

        override fun onEvent(p0: Int, p1: String?) {
            val event: Int = p0 and FileObserver.ALL_EVENTS

            when(event){
                FileObserver.OPEN -> {
                    println("open")
                }
                FileObserver.CREATE -> {
                    println("create")
                }
                FileObserver.MODIFY -> {
                    println("modify")
                }
            }
        }



    }
}