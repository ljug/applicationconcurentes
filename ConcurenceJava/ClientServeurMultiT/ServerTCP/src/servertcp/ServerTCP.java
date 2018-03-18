package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Pascal Fares
 */
public class ServerTCP {

    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static PrintWriter getoutput(Socket p) throws IOException {
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ecoute;
        ecoute = new ServerSocket(2000);
        System.out.printf("L'adresse de la socket d'écoute est %s\n",
                ecoute.getLocalSocketAddress());
        while (true) {
            Socket serviceSocket = ecoute.accept();
            System.out.printf("L'adresse de la socket cliente (remote) est %s\n",
                    serviceSocket.getRemoteSocketAddress());
            BufferedReader ir = getInput(serviceSocket);
            PrintWriter reply = getoutput(serviceSocket);
            String line;
            line = ir.readLine();
            System.out.printf("Reçu %s du Client\n", line);
            reply.printf("Reponse Serveur %s\n", line);
            reply.flush();
            serviceSocket.close();
        }

    }

}
