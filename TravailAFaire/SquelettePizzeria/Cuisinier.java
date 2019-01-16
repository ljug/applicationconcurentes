import java.util.Random;
public class Cuisinier implements Runnable {
	String name;
	Random r = new java.util.Random();

	Cuisinier(String nom){
		name=nom;
	}
	public void run(){
		for (int i=1;i<10;i++){
			int c=Plat.garnitures.length;
			int commande = r.nextInt(c);
			String garniture=Plat.garnitures[commande];
			Plat p=new Plat(garniture);
			int numeroPizza=p.getRang();
			System.out.println("Cuisinier " +name +" a prepare la " + numeroPizza +"eme pizza qui est garnie de : " + garniture);
			try{
				Pizzeria.leComptoir.put(p);
			}
			catch(Exception e){System.err.println("Cuisinier "+name+" n'a pas reussi a deposer sa pizza " + i);
			}
			System.out.println("Cuisinier " +name +" a pose la " + numeroPizza +"eme pizza sur le comptoir");
		}
	}
}
