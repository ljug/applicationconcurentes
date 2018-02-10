
<iframe src="https://docs.google.com/presentation/d/e/2PACX-1vQP1JmgpVHfxPyPwDkKhQlgIhkd4nmrxzyMCgWFm-BZbRK3NMPt-nm8gPRNEEbsXnQTeZP2DsFlsWAH/embed?start=false&loop=false&delayms=5000" frameborder="0" width="960" height="569" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>

Cet exemple ne fonctionne pas dans tous les cas de figure... Il pourrait être en "deadlock" dans plusieurs cas de figure!
Pourquoi?
```Java
public class ProcessExec2 {
    /**
     * Un chemin pour vos execution et réféence de fichier, adaptez le a votre
     * Environement
     */
    public static final String CHEMIN = "/home/pascalfares";
    
    /**
     * Récuperer le standard output du processus fils
     * @param p
     * @return 
     */
    private static BufferedReader getOutput(Process p) {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    /**
     * Récuperer le standard error du processus fils
     * @param p
     * @return 
     */
    private static BufferedReader getError(Process p) {
        return new BufferedReader(new InputStreamReader(p.getErrorStream()));
    }
    
    private static PrintWriter getInput(Process p){
        return new PrintWriter (new OutputStreamWriter(p.getOutputStream()));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Début du programme 2");
        try {
            String[] commande = {CHEMIN+"/bin/hello.sh", "Bonjour"};
            Process p = Runtime.getRuntime().exec(commande);
            BufferedReader output = getOutput(p);
            BufferedReader error = getError(p);
            PrintWriter input  = getInput(p);
            
            String ligne;

            input.printf("Un texte\n");
            input.flush();
            
            while ((ligne = output.readLine()) != null) {
                System.out.println(ligne);
            }
            
            while ((ligne = error.readLine()) != null) {
                System.out.println(ligne);
            }
            
            p.waitFor();
        
        } catch (IOException|InterruptedException ex) {
            Logger.getLogger(ProcessExec2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fin du programme 2");
    }
    
}
```

