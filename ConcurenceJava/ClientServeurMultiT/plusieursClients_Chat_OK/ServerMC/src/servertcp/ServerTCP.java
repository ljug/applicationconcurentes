/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Pascal Fares
 */
public class ServerTCP {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket l = new ServerSocket(2010);
        GestionListeClients listeClients = new GestionListeClients();
        System.out.println(l.getLocalSocketAddress());
        while (true) {
            Socket serviceSocket = l.accept();
            Thread nc = new Thread(new EchoService(serviceSocket,listeClients));
            nc.setDaemon(true);
            nc.start();
        }
    }
}
