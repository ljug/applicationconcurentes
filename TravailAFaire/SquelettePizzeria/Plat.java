
public class Plat {
	String garniture;
	static int totalPizzaFabriquees=0;
	int rang=0; // pour pouvoir reperer/identifier les pizzas fabriquees puis deposees sur le comptoir
	static String[] garnitures={"Fromage","Champignons","Chorizzo"};

	Plat(String garniture){
		this.garniture=garniture;
		this.rang=++Plat.totalPizzaFabriquees;
	}
	public String getGarniture(){
		return garniture;
	}
	public int getRang(){
		return rang;
	}
	public String toString(){
		return "Pizza "+ rang + "garnie de "+ garniture;
	}
}
