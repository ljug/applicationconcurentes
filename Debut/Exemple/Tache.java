public class Tache extends Thread {
    String nomTache;

    Tache(String n){
        nomTache=n;
    }

    @Override
    public void run() {
        System.out.println("print debut depuis "+nomTache);
        System.out.println("print fin depuis "+nomTache);
    }
}