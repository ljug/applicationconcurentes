package cddc;

/**
 *
 * @author Pascal Fares
 */
public class Tache1 implements Runnable {

    /**
     * La réfeŕence vers la donnée partagée
     */
    private Data reftoData;
    /**
     * La donné privée pour compté le nombre d'incréments réalisés
     */
    private int donneePriv;

    public Tache1(Data data) {
        reftoData = data;
        donneePriv = 0;
    }

    @Override
    public void run() {
        System.out.println("debut t1");
        for (int i = 0; i < 100000; i++) {
            reftoData.inc();
            donneePriv++;
        }
        System.out.println("fin t1");
    }

    public Data getReftoData() {
        return reftoData;
    }

    public void setReftoData(Data reftoData) {
        this.reftoData = reftoData;
    }

    public int getDonneePriv() {
        return donneePriv;
    }

    public void setDonneePriv(int donneePriv) {
        this.donneePriv = donneePriv;
    }

}
