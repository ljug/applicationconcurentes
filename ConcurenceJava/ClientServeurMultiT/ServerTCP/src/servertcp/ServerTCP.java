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
/**
     * Récupère le flux d'entrée d'une Socket et l'encapsule dans un BufferedReader 
     * Un BufferedReader permet de Lire le texte à partir d'un flux d'entrée de caractères, en mettant
     * en mémoire tampon les caractères afin de permettre une lecture efficace 
     * des caractères, des tableaux et des lignes.
     * @param p la SOcket
     * @return le BufferedReader crée
     * @throws IOException 
     */
    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }
/**
     * Récupère le flus de sortie de la socket et l'encapsule dans un PrintWriter
     * Imprime des représentations formatées d'objets dans un 
     * flux de sortie de texte. Cette classe implémente toutes les méthodes 
     * d'impression trouvées dans PrintStream.
     * @param p la Socket
     * @return le PrintWriter crée
     * @throws IOException 
     */
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
            //try-with-resource
            try (Socket serviceSocket = ecoute.accept()) {
                //Acceper un client l.accept()
                System.out.println(serviceSocket.getRemoteSocketAddress());
                BufferedReader ir = getInput(serviceSocket);
                PrintWriter reply = getoutput(serviceSocket);
                String line = ir.readLine();
                System.out.printf("je répond ping %s\n", line);
                reply.printf("je répond ping %s\n", line);
                reply.flush();

            }
        }

    }

}
