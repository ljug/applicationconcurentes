package cddc;

/**
 *
 * @author Pascal Fares
 */
public class Tache2 implements Runnable {

    /**
     * La réfeŕence vers la donnée partagée
     */
    private Data referenceDonnees;
    /**
     * La donné privée pour compté le nombre d'incréments réalisés
     */
    private int donneePrivee;

    public Tache2(Data data) {
        referenceDonnees = data;
    }

    @Override
    public void run() {
        System.out.println("debut t2");
        while (donneePrivee < 100000) {
            referenceDonnees.inc();
            donneePrivee++;
            // System.out.printf(" <T2 Priv : %d Glob: %d> ",
            // DonneePrivee, referenceDonnees.getDonee());
        }
        System.out.println("fin t2");
    }

    public Data getReferenceDonnees() {
        return referenceDonnees;
    }

    public void setReferenceDonnees(Data referenceDonnees) {
        this.referenceDonnees = referenceDonnees;
    }

    public int getDonneePrivee() {
        return donneePrivee;
    }

    public void setDonneePrivee(int donneePrivee) {
        this.donneePrivee = donneePrivee;
    }

}
