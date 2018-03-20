/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class EchoService implements Runnable {

    private final InfoClients ic;
    private GestionListeClients listeClients;
    
    public EchoService(Socket s, GestionListeClients listeClients) throws IOException {
        ic=new InfoClients(s);
        this.listeClients=listeClients;
        listeClients.add(ic);
    }

    @Override
    public void run() {
        
        try {
            System.out.println(ic.getServiceClientSocket().getRemoteSocketAddress());
            //ir = ServerTCP.getInput(serviceSocket);
            //PrintWriter reply = ServerTCP.getoutput(serviceSocket);
            String line;
            System.out.println("Avant boucle");
            while (!(line = ic.getReader().readLine()).equals(".")) {
                System.out.println("Dans boucle");
                System.out.printf("J'ai recus %s\n", line);
                listeClients.sendMessageToAll(line);
            }
            ic.getWriter().printf(".\n");
        } catch (IOException ex) {
            Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                listeClients.remove(ic);
            } catch (IOException ex) {
                Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
