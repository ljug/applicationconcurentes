package servertcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares
 */
public class EchoService implements Runnable {

    Socket serviceSocket;

    public EchoService(Socket s) {
        serviceSocket = s;
    }

    @Override
    public void run() {
        BufferedReader ir = null;
        try {
            System.out.println(serviceSocket.getRemoteSocketAddress());
            ir = ServerTCP.getInput(serviceSocket);
            PrintWriter reply = ServerTCP.getoutput(serviceSocket);
            String line;
            while (!(line = ir.readLine()).equals(".")) {
                System.out.printf("J'ai recu %s\n", line);
                reply.printf("R: %s\n", line);
            }
            reply.printf("Bye %s",serviceSocket.getRemoteSocketAddress());
        } catch (IOException ex) {
            Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                serviceSocket.close();
                ir.close();
            } catch (IOException ex) {
                Logger.getLogger(EchoService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
