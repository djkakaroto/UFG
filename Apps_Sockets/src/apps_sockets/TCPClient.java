/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps_sockets;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class TCPClient {

    public static void main(String argv[]) throws Exception {

        Socket cliente = null;
        Scanner teclado = null;
        PrintStream saida = null;
        boolean sair = false;

        // Conecta ao servidor
        try {
            cliente = new Socket("localhost", 6789);
            System.out.println("Conectado ao " + cliente.getInetAddress().getHostAddress() + "\nPorta: " + cliente.getLocalPort() + "\n");
        } catch (Exception e) {
            System.err.println("Não foi possível se conectar ao servidor...");
        }

        teclado = new Scanner(System.in);
        saida = new PrintStream(cliente.getOutputStream());

        do {
            
            String aux = null;
            aux = teclado.nextLine();
            aux = aux.replace("\n", "").replace("\r", "");
            saida.println(aux);
            //System.out.println("Saida: " + aux );

            System.out.println("\nDeseja Sair: (S/N)");
            String resp = teclado.nextLine();
            resp = resp.replace("\n", "").replace("\r", "");
            resp = resp.substring(0, 1);

            // Verifica a resposta para continuar enviando
            if (resp.equals("S") | resp.equals("s")) {
                System.out.println("\nSaindo...");
                sair = true;
            } 
             

        } while (sair == false);

        saida.close();
        teclado.close();
        cliente.close();

    }

}
