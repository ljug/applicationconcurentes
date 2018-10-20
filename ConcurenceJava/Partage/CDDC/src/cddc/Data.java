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
