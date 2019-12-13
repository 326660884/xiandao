package cn.cnic.xiandao.service.impl;

import org.springframework.stereotype.Service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

@Service
public class BroadcastNotice {
    public  void send(String data)
    {
        String host = "255.255.255.255";//广播地址
        int port = 9999;//广播的目的端口
        String message = data;//用于发送的字符串
        try
        {
            InetAddress adds = InetAddress.getByName(host);
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(message.getBytes(),message.length(), adds, port);
            ds.send(dp);
            ds.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
