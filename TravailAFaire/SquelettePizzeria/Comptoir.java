//squelette d'une classe qui represente le Comptoir
public class Comptoir {
	Plat[] buffer; // devra si possible etre gere en mode FIFO voir par exemple ListeCirculaire fournie dans un précedent TP

Comptoir(int capacite){
	//...
}
public void put (Plat p) throws InterruptedException{
	// poser le plat p sur le comptoir, en respectant
	// la contrainte de synchronisation "le comptoir n'est pas plein",
	// et en faisant bien sur attention au probleme d'acces en exclusion
	// mutuelle au buffer
}
public Plat take() throws InterruptedException {
	// retirer un plat du comptoir, en respectant 
	// la contrainte de synchronisation "le comptoir n'est pas vide",
	// et en faisant bien sur attention au probleme d'acces en exclusion
	// mutuelle au buffer
}
}
