public class LanceTache {
    public static void main(String args[]) {

        Tache t1, t2, t3;

        t1 = new Tache("t1");
        t2 = new Tache("t2");
        t3 = new Tache("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}