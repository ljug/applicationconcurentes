/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processexec;

import java.util.Arrays;

/**
 *
 * @author Acer
 */
public class App {
    public static void main(String ...args) {
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
            default:
                break;
        }
    }
}
