package exemple;

/**
 * Une classe qui implement l'interface Runnable
 * @author Pascal Fares
 */
public class ClasseRunnbale implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            System.out.printf("%s ",Thread.currentThread().getName());
        }
    }
    
}
