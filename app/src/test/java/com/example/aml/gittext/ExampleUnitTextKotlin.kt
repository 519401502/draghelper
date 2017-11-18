package com.example.aml.gittext


import org.junit.Test
import java.io.*
import java.net.HttpURLConnection
import java.net.Socket
import java.net.SocketAddress
import java.net.URL

/**
 * Created by 18624915319 on 2017/11/11.
 */
class ExampleUnitTextKotlin{

    /**
     * java 断点续传.
     */
    @Test fun text() {
        val url = URL("http://gdown.baidu.com/data/wisegame/2336735c7e89381c/weixin_1120.apk")
        val httpUrlContent = url.openConnection()
        httpUrlContent.doInput = true
        httpUrlContent.doOutput = true
        //设置头信息Range, 从第1000位字节开始拉取，包括1000
        httpUrlContent.setRequestProperty("Range", "bytes=1000-")
        httpUrlContent.connect()
        var length = httpUrlContent.contentLength
        val inputStream = httpUrlContent.getInputStream() ?: return
        val byteArray = ByteArrayOutputStream()
        byteArray.write(inputStream.readBytes(length))
        save(byteArray.toByteArray())
    }

    fun save(b: ByteArray) {
        //打开xxx.apk文件输出流
        var file = File("xxx.apk")
        val byteArrays = ByteArrayOutputStream()
        //如果xxx.apk已存在,将原有字节拉取出来，与新拉去的字节进行拼接
        if (file.exists()) {
            var input = file.inputStream()
            var bytess = ByteArray(1)
            while ((input.read(bytess)) > -1) {
                var lens = bytess.size
                byteArrays.write(bytess, 0, lens)
            }
        }
        byteArrays.write(b)
        val output = FileOutputStream(file)
        //字节输出
        output.write(byteArrays.toByteArray())
        output.flush()
        output.close()
    }

    /**
     * websocket测试
     */
    @Test fun webSocketText() {
        val url = URL("ws://127.0.0.1:8080/text")
        val conection = url.openConnection() as HttpURLConnection
        conection.setRequestProperty("Upgrade", "websocket")
        conection.setRequestProperty("Connection", "Upgrade")
        conection.setRequestProperty("Sec-WebSocket-Key", "xqBt3ImNzJbYqRINxEFlkg==")
        conection.setRequestProperty("Sec-WebSocket-Version", "13")
        conection.setRequestProperty("Sec-WebSocket-Protocol", "chat, superchat")

        val map = conection.headerFields

        println("显示响应Header信息...\n")

        for (entry in map.entries) {
            println("Key : " + entry.key +
                    " ,Value : " + entry.value)
        }

        println("\n使用key获得响应Header信息 \n")
        val server = map.get("Server")
        var input = conection.inputStream
        val reader = BufferedReader(InputStreamReader(input))
        println(reader.readLine())




//        var webSocket = WebSocketConnection()

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
