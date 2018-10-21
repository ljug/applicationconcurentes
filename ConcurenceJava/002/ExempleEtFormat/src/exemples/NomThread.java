package exemples;


/**
 *
 * @author pascalfares
 */
public class NomThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = Thread.currentThread();
        // Affiche caractéristiques de la thread courante 
        System.out.println(t);
        // Changer le nom :  donne un nouveau nom 
        t.setName("ISSAE");
        System.out.println(t);
        // Rend le processus léger courant 
        // inactif pendant 1 seconde 1000ms
        Thread.sleep(1000);
        System.out.println("fin");
    }
}
