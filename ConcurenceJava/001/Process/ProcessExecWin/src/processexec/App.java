package processexec;

import java.util.Arrays;

/**
 * Lancements des exemples choisir le nom de l'exemple
 * Execi ...
 * avec éventuelement d'autres paramètres a fournir au programme Execi
 * @author Pascal Fares
 */
public class App {
    /**
     * Afficher un tableaux de String
     * @param args : tableaux de String (représente les paramètres du programme)
     */
    public static void afficheArgs(String ...args){
        for (int i=0; i< args.length; i++) {
            System.out.printf("%s ",args[i]);
        }
        System.out.println();
    }
    public static void main(String... args) {
        afficheArgs(args);
        switch (args[0]) {
        case "Exec0":
            ProcessExec0.main(Arrays.copyOfRange(args, 1, args.length));
            break;
        case "Exec1":
            ProcessExec1.main(Arrays.copyOfRange(args, 1, args.length));
            break;
        case "Exec11":
            ProcessExec11.main(Arrays.copyOfRange(args, 1, args.length));
            break;
        case "Exec2":
            ProcessExec2.main(Arrays.copyOfRange(args, 1, args.length));
            break;
        case "Exec21":
            ProcessExec21.main(Arrays.copyOfRange(args, 1, args.length));
            break;
        default:
            System.out.println("Aucun des programmes connus: "
                + "\n\t Exec0 Exec1 Exec11 Exec2 Exec21");
            break;
        }
    }
}
