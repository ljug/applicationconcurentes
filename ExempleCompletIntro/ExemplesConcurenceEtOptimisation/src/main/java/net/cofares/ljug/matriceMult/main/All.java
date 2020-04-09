package net.cofares.ljug.matriceMult.main;

/**
 *
 * @author Pascal Fares
 */
public class All {
    public static void main(String ...args){
        SerialMain.main(args);
        ParallelRowMain.main(args);
        ParallelGroupMain.main(args);
        ParallelIndividualMain.main(args);              
    }
}
