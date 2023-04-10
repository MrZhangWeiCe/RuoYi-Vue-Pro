package com.ruoyi.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class TcpServerRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TcpServerRunner.class);

    public OutputStream ops;

    @Override
    public void run(String... args) throws Exception {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            // 创建ServerSocket
            serverSocket = new ServerSocket(8882);
            log.debug("TCP服务端已启动，等待客户端连接...");
//            System.out.println("TCP服务端已启动，等待客户端连接...");

            while (true) {
                // 等待客户端连接请求
                clientSocket = serverSocket.accept();
                // 实例化BufferedReader对象
                ops =  clientSocket.getOutputStream() ;
                System.out.println("客户端连接成功！");
                log.debug("客户端连接成功！");

                // 接收数据
                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String message = br.readLine();
                if (message != null) {
//                    System.out.println("接收到客户端数据：" + message);
                    log.debug("接收到客户端数据：" + message);

                    // 发送数据
//                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
//                    writer.println("Hello, TCP Client!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    /**
     * 通过短信猫发送短信通知
     * @param phone 手机号
     * @param msg 消息内容
     */
    public void sendSMSByTCP(String phone, String msg) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String str1 = "86" + phone + ":0:" + msg;
        try {
            ops.write((str1.getBytes("GBK")), 0, str1.getBytes("GBK").length);
            ops.flush();
            log.debug("发送数据======="+str1);
        } catch (IOException ex) {
            log.debug("短信发送报错========"+ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
}

