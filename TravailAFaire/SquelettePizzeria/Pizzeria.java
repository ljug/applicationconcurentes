import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
public class Pizzeria {
	//static BlockingQueue<Plat> leComptoir = new ArrayBlockingQueue<Plat>(4);
	//static ComptoirCondition leComptoir = new ComptoirCondition(4);
	//static ComptoirMoniteur leComptoir = new ComptoirMoniteur(4);
	//static ComptoirSemaphore leComptoir = new ComptoirSemaphore(4);
	static Comptoir leComptoir = new Comptoir(4);
	public static void main(String[] args) {
		Client[] clients = {
				new Client("Toto"),
				new Client("Bibi"),
				new Client("Guillaume")};
		Cuisinier[] cuisiniers = {
				new Cuisinier("Gabriel"),
				new Cuisinier("Christophe")};
		for (int i=0;i<cuisiniers.length;i++){
			new ThreaD(cuisiniers[i]).start();
		}
		for (int i=0;i<clients.length;i++){
			new Thread(clients[i]).start();
		}
	}

}
