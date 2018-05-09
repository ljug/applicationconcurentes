/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demon;

/**
 *
 * @author Pascal Fares
 */
public class Demon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Execution demon");
                }
            } finally {
                System.out.println("Fin demon");
            }
        });
        
       if (args.length == 1) {
           if (args[0].equals("demon")) t.setDaemon(true);
           
       }
       else {
           System.out.println("Lancer en donnant demon "
                   + "ou utilisateur et voyez la différence!");
       }
       t.start();
    }

}
