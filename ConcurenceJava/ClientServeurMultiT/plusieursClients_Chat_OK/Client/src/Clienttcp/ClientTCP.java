/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Pascal Fares
 */
public class ClientTCP {

    private static BufferedReader getInput(InputStream is) throws IOException {
        return new BufferedReader(new InputStreamReader(is));
    }

    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static PrintWriter getoutput(Socket p) throws IOException {
        
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()), true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket l = null;
        try {
            l = new Socket("localhost", 2010);
            System.out.println(l.getLocalSocketAddress());
            //Input stream de la socket (depuis le serveur)
            BufferedReader ir = getInput(l);
            //Input stream du stdin
            BufferedReader stdin = getInput(System.in);
            //Output de la socket vers le serveur
            PrintWriter envoyer = getoutput(l);
            
            Thread lireStdOutSock = 
                    new Thread (new ServiceInOut(stdin, envoyer, "Std->sock"));
            Thread lireSockStdOut= 
                    new Thread (new ServiceInOut(ir, new PrintWriter(System.out), "Sock->Std"));
            lireStdOutSock.start();
            lireSockStdOut.start();
            lireStdOutSock.join();
            lireSockStdOut.join();
        } finally {
            if (l != null) {
                l.close();
            }
        }
    }

}
