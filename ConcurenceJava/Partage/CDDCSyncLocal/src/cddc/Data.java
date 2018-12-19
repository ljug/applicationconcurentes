package cddc;

/**
 * Exemple de données, sera partagé entre plusieurs Threads
 *
 * @author Pascal Fares
 */
public class Data {

    private int donnee;

    public Data() {
        setDonnee(0);
    }

    public void inc() {
        setDonnee(getDonnee() + 1);
    }

    public int getDonnee() {
        return donnee;
    }

    public void setDonnee(int donnee) {
        this.donnee = donnee;
    }
}
