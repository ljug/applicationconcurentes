/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncwaitnotify;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pascal fqres
 */
public class Util {

    public static String currentTime() {
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SS");
        Date resultdate = new Date(yourmilliseconds);
        //System.out.println(sdf.format(resultdate));
        return sdf.format(resultdate);
    }
}
