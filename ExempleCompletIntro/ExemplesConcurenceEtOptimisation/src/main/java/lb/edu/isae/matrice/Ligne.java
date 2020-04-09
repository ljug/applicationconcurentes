package lb.edu.isae.matrice;

/**
 *
 * @author Pascal Fares
 */
public class Ligne {
    private Double[] ligne;
    
    public Ligne(int taille) {
        ligne = new Double[taille];
    }
    public Ligne(Double ...valeurs) {
        this(valeurs.length);
        System.arraycopy(valeurs, 0, this.ligne, 0, valeurs.length);
    }

    /**
     * @return the ligne
     */
    public Double[] getLigne() {
        return ligne;
    }
    /**
     * @param pos
     * @return element à la position pos de la ligne
     */
    public Double getLigne(int pos) {
        return ligne[pos];
    }

    /**
     * @param ligne the ligne to set
     */
    public void setLigne(Double[] ligne) {
        this.ligne = ligne;
    }
    
    /**
     * @param elem
     * @param pos
     */
    public void setLigne(Double elem, int pos) {
        this.ligne[pos] = elem;
    }
}
