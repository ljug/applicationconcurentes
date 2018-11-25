public class Tache implements Runnable {

    @Override
    public void run() {
        try {
            System.out.printf("Debut traitement %s", Thread.currentThread());
            Thread.sleep(10);
            System.out.printf("Fin traitement %s", Thread.currentThread());
        } catch (InterruptedException ex) {
            //Passer à la suite
        }
        
    }
}
