/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps_sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class TCPServer {

    public static void main(String argv[]) throws Exception {

        ServerSocket servidor = new ServerSocket(6789);
        System.out.println("Iniciando servidor... ");
        System.out.println("Listen: " + servidor.getLocalPort());

        Socket cliente = servidor.accept();
        System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

        Scanner entrada = new Scanner(cliente.getInputStream());

        while (entrada.hasNextLine()) {
            System.out.println("Cliente send: " + entrada.nextLine());
        }

        entrada.close();
        servidor.close();

    }

}
