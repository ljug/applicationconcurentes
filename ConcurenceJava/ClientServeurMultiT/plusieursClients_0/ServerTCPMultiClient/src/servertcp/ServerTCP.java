/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

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
public class ServerTCP {

    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    
    
    private static PrintWriter getoutput(Socket p) throws IOException{
        return new PrintWriter (new OutputStreamWriter(p.getOutputStream()));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket l = new ServerSocket(2001);
        System.out.println(l.getLocalSocketAddress());
        while (true) {
            try (Socket serviceSocket = l.accept()) {
                System.out.println(serviceSocket.getRemoteSocketAddress());
                BufferedReader ir = getInput(serviceSocket);
                PrintWriter reply = getoutput(serviceSocket);
                String line;
                while (!(line = ir.readLine()).equals(".")) {
                    System.out.printf("je répond ping %s\n", line);
                    reply.printf("je répond ping %s\n", line);
                    reply.flush();
                }
            }
        }
    }
    
}
