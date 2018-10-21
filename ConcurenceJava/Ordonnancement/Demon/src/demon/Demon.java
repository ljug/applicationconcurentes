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
    public static Thread arrange1() {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Execution demon");
                }
            } finally {
                System.out.println("Fin demon");
            }
        });
        return t;
    }

    /**
     * Par classe anonyme (instance de Runnable)
     * @return 
     */
    public static Thread arrange2() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println("Execution demon");
                    }
                } finally {
                    System.out.println("Fin demon");
                }
            }
        });
        return t;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t1 = arrange1();

        if (args.length == 1) {
            if (args[0].equals("demon")) {
                t1.setDaemon(true);
            }

        } else {
            System.out.println("Lancer en donnant demon "
                    + "ou utilisateur et voyez la différence!");
        }
        t1.start();
    }

}
