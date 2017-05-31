/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps_sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author diego
 */
public class UDPClient {

    public static void main(String args[]) throws Exception {

        BufferedReader inFromUser
                = new BufferedReader(new InputStreamReader(System.in));

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress IPAddress = InetAddress.getByName("hostname");
            
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            
            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            
            clientSocket.send(sendPacket);
            
            DatagramPacket receivePacket
                    = new DatagramPacket(receiveData, receiveData.length);
            
            clientSocket.receive(receivePacket);
            
            String modifiedSentence
                    = new String(receivePacket.getData());
            
            System.out.println("FROM SERVER:" + modifiedSentence);
        }
    }
}
