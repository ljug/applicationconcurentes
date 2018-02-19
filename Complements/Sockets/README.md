# Les Socket par l'exemple

## Le serveur d'echo

```Java
import java.net.*;
import java.io.*;
 
public class EchoServer {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 1) {
            System.err.println("Utilisation: java EchoServer <numéro port>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[0]);
         
        try (
            ServerSocket serverSocket =
                new ServerSocket(Integer.parseInt(args[0]));
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Peoblème lors de l'écoute du port "
                + portNumber + " ou lors de la communication avec le client");
            System.out.println(e.getMessage());
        }
    }
}
```

## Le client d'echo

```Java
public class EchoClient {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 2) {
            System.err.println(
                "Utilisation: java EchoClient <nom hote> <numéro port>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
 
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Aucune info concernant " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Pas d'E/S lors de la communication avec " +
                hostName);
            System.exit(1);
        } 
    }
}
```