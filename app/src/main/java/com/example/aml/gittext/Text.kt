package com.example.aml.gittext

import android.util.Log

/**
 * Created by 18624915319 on 2017/11/5.
 */
fun main(args: Array<String>) {
    var str: String = local {
        println("第一层接收")
        return@local "第二层接收"
    }
    println(str)

}

//高阶函数
fun <T : String> local(obj:() -> String): T {
    var str = obj.invoke()
    println(str)
    return "第三层接收" as T
}
