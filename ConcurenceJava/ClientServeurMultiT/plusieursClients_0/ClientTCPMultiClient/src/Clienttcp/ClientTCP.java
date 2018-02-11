/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
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

    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static PrintWriter getoutput(Socket p) throws IOException {
        //Avec autoflush
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()), true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket l = null;
        try {
            l = new Socket("localhost", 2000);
            System.out.println(l.getLocalSocketAddress());
            BufferedReader ir = getInput(l);
            PrintWriter envoyer = getoutput(l);
            for (int i = 0; i < 100; i++) {
                envoyer.printf("#%2d : Bonjour\n", i);
                System.out.println(ir.readLine());
            }
            envoyer.printf(".\n");
        } finally {
            if (l != null) {
                l.close();
            }
        }
    }

}
