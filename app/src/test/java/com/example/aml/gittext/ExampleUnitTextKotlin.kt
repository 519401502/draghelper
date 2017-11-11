package com.example.aml.gittext

import org.junit.Test
import java.io.*
import java.net.URL

/**
 * Created by 18624915319 on 2017/11/11.
 */
class ExampleUnitTextKotlin{

    /**
     * java 断点续传
     */
    @Test fun t() {
        val url = URL("http://gdown.baidu.com/data/wisegame/2336735c7e89381c/weixin_1120.apk")
        val httpUrlContent = url.openConnection()
        httpUrlContent.doInput = true
        httpUrlContent.doOutput = true
        httpUrlContent.setRequestProperty("Range", "bytes=1000-")
        httpUrlContent.connect()
        var length = httpUrlContent.contentLength
        val inputStream = httpUrlContent.getInputStream() ?: return
        val byteArray = ByteArrayOutputStream()
//        var bytes = ByteArray(1)
        byteArray.write(inputStream.readBytes(length))
//        while ((inputStream.read(bytes)) > 0){
//            var len = bytes.size
//            byteArray.write(bytes)
//        }
        println("接收到的length = " + byteArray.size())


        println("length = $length")


        var file = File("weixin.apk")
        val byteArrays = ByteArrayOutputStream()
        if (file.exists()) {
            var input = file.inputStream()
            var bytess = ByteArray(1)
            while ((input.read(bytess)) > -1) {
                var lens = bytess.size
                byteArrays.write(bytess, 0, lens)
            }
        }
        byteArrays.write(byteArray.toByteArray())

        val output = FileOutputStream(file)
        output.write(byteArrays.toByteArray())
        output.flush()
        output.close()
    }

}