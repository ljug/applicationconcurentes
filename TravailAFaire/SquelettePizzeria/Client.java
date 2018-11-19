import java.util.Random;

public class Client implements Runnable {
	private String name;
	Random r = new java.util.Random();

	Client(String nom){
		name=nom;
	}
	
	public void run() {
		for (int i=1;i<2;i++){
			System.out.println("Client " +name +" commande sa " + i +"eme pizza garnie");
			Plat p = null;
			try{
				p=Pizzeria.leComptoir.take();
			}
			catch(InterruptedException e){System.err.println("Client "+name+" en a eu marre d'attendre!");
			}
			System.out.println("\t \t Client " +name +" a obtenu la " + p.getRang() +"eme pizza; et elle est garnie de " + p.getGarniture());
		}
	}
}

