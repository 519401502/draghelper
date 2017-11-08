package com.example.aml.gittext

import android.util.Log

/**
 * Created by 18624915319 on 2017/11/5.
 */
class Text {

    fun text(arg: String, argss: String): String{
        var s = "测试"
        Log.d("~", "测试类 第二次 text分支添加")

        Log.d("", "切换远程库分支测试")


        return s
    }

    suspend fun su(blank: suspend (str: String, st: String) -> String): String {
        blank.invoke("", "")
        return ""
    }

    fun suspendText():String{
        println("fdsafsa")
//        val lists = arrayListOf(1,3,2)git
//        lists.filter {
//            return@filter true
//        }
//        for (i in 0 until lists.size)
//            println(lists[i])
        return ""
    }
}

fun main(args: Array<String>) {
    val text = Text()
    text.suspendText()

}
