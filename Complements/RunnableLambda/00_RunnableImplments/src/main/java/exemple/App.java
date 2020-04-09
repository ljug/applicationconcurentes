package exemple;

/**
 * Créer n thread de type ClasseRunnable
 * utilisation java exemple.App n
 * argument n (String représentant un entier) 
 * passé au main à la ligne de commande
 * 
 * @author Pascal Fares
 */
public class App {
    public static void main (String ...args) throws InterruptedException {
        int nbThreadDemandes=0;
        if (args.length ==1) {
            nbThreadDemandes = Integer.parseInt(args[0]);
        } else {
            System.out.println("Utilisation : java exemple.App <n>");
            System.exit(1);
        }
        Thread[] tabThread = new Thread[nbThreadDemandes];
        
        //Créer les thread
        for (int i=0; i<nbThreadDemandes; i++) {
            tabThread[i] = new Thread(new ClasseRunnbale());
            tabThread[i].setName("t"+i);
        }
        
        //lancer les thread
        for (int i=0; i<nbThreadDemandes; i++) {
            tabThread[i].start();
        }
        
        //Attendre la fin de tous les thread
        for (int i=0; i<nbThreadDemandes; i++) {
            tabThread[i].join();
        }
        
    }
}
