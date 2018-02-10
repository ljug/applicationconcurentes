/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cddc;

/**
 *
 * @author Pascal Fares
 */
public class Data {
    
    private int donnee;

    public Data() {
        donnee=0;
    }
    public void inc() {
        donnee++;
    }
    /**
     * Get the value of donee
     *
     * @return the value of donee
     */
    public int getDonee() {
        return donnee;
    }

    /**
     * Set the value of donee
     *
     * @param donee new value of donee
     */
    public void setDonee(int donee) {
        this.donnee = donee;
    }

    
}
