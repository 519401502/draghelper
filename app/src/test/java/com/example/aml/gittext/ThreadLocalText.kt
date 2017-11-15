package com.example.aml.gittext

import org.junit.Test

/**
 * Created by 18624915319 on 2017/11/15.
 */
class ThreadLocalText {

    @Test
    fun text() {
        val local = object : ThreadLocal<Int>(){
            override fun initialValue(): Int {
                super.initialValue()
                return 0
            }
            override fun get(): Int {
                return super.get() + 1
            }
        }
        for (i in 0..2){
            Thread(Runnable {
                println(local.get())
            }).start()
        }
    }
}