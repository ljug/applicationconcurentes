/**
 * Writer.java
 *
 * A writer to the database.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

public class Writer extends Thread
{
   public Writer(int w, Database db)
   {
      writerNum = w;
      myValuePair=w*10;
      server = db;
   }

   public void run()
   {
     while (true)
      {
       System.out.println("writer " + writerNum + " is sleeping.");
       Database.napping();
       
       System.out.println("writer " + writerNum + " wants to write.");
       server.startWrite();
       
       // you have access to write to the database
       System.out.println("writer " + writerNum + " is writing.");
       Database.napping();
       server.effectiveWriting(myValuePair,myValuePair+1);

       server.endWrite();
       System.out.println("writer " + writerNum + " is done writing.");
      }
   }
   
   private Database  server;
   private int       writerNum;
   private int myValuePair;
}
