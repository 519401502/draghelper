package com.example.aml.gittext;

import android.util.Xml;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Socket socket = new Socket("127.0.0.1", 8080);
        StringBuffer sb = new StringBuffer("GET /text HTTP/1.1\r\n");
        // 以下为请求头
        sb.append("Host:127.0.0.1:8080\r\n");
        sb.append("Connection:Upgrade\n");
        sb.append("Origin:null\n");
        sb.append("Sec-WebSocket-Extensions:x-webkit-deflate-frame\n");
        sb.append("Sec-WebSocket-Key:puVOuWb7rel6z2AVZBKnfw==\n");
        sb.append("Sec-WebSocket-Version:13\n");
        sb.append("Upgrade:websocket\n");

        // 注意这里要换行结束请求头
        sb.append("\r\n");
        System.out.println(sb.toString());
        OutputStream os = socket.getOutputStream();
        os.write(sb.toString().getBytes());
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        PrintWriter writer = new PrintWriter(os);
        while ((len = is.read(bytes)) != -1) {
            /**
             * 根据WebSocket处理信息
             */
                        System.out.println("start");
            System.out.println(len);

            baos.write(bytes, 0, len);
            String res = new String(bytes);

            System.out.println(res);
            System.out.println("end");
            bytes = new byte[1024];
            System.out.println("- - - - - - - - -");
            System.out.println(bytes[0]);
            System.out.println(bytes[1]);
            System.out.println(new String(baos.toByteArray()));
            System.out.println("- - - - - - - - -");
            byte[] b = new byte[2];
            String s = "服务器你好，可能你现在还读不懂我，以后你会懂我的";
            byte[] strBytes = s.getBytes();
            b[0] = (byte) 0x81;
            b[1] = (byte) 0x82;
            byte[] sum = new byte[strBytes.length + b.length];
            System.arraycopy(b, 0, sum, 0, b.length);
            System.arraycopy(strBytes, 0, sum, b.length, strBytes.length);

            os.write(sum);
            os.flush();

        }
        socket.close();
    }

}