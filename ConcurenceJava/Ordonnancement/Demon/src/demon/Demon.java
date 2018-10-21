package demon;

/**
 *
 * @author Pascal Fares
 */
public class Demon {

    //Trois méthodes pour initialiser un Thread
    /**
     * par lambda
     * @return Thread
     */
    public static Thread arrange1(String name) {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Execution de "+ Thread.currentThread());
                }
            } finally {
                System.out.println("Fin demon");
            }
        });
        t.setName(name);
        return t;
    }

    /**
     * Par classe anonyme (instance de Runnable)
     * @return 
     */
    public static Thread arrange2(String name) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println("Execution de "+ Thread.currentThread());
                    }
                } finally {
                    System.out.println("Fin demon");
                }
            }
        });
        t.setName(name);
        return t;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t1 = arrange1("Tache 1 par lambda");
        Thread t2 = arrange1("Tache 2 par classe anonyme");

        if (args.length == 1) {
            if (args[0].equals("demon")) {
                t1.setDaemon(true);
                t2.setDaemon(true);
            }

        } else {
            System.out.println("Lancer en donnant demon "
                    + "ou utilisateur et voyez la différence!");
        }
        t1.start();t2.start();
    }

}
