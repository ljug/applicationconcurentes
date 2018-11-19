/**
 * Database.java
 *
 * This class contains the methods the readers and writers will use
 * to coordinate access to the database. Access is coordinated using Java synchronization.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * @version 1.1 - Ocotber 2, 2001 - Added output message to endRead().
 *
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */
 
public class Database
{  
   public Database()
   {
      readerCount = 0;
      dbReading = false;
      dbWriting = false;
      data = new Data(12,13);
   }

   // readers and writers will call this to nap
   public static void napping()
   {
     int sleepTime = (int) (NAP_TIME * Math.random() );
     try { Thread.sleep(sleepTime*1000); } 
     catch(InterruptedException e) {}
   }

    //
   public String effectiveReading()
   {
       return "["+data.getElt1()+","+data.getElt2()+"]";
   }
   
    public void effectiveWriting(int elt1, int elt2)
   {
       data.setElt1(elt1);
       Thread.yield(); // to force problems in case not well synchronized
       data.setElt2(elt2);
   }


   // reader will call this when they start reading
   public synchronized int startRead()
   { 
      while (dbWriting == true)
      {
         try { wait(); }
         catch(InterruptedException e) {}
      }

      ++readerCount;

      // if I am the first reader tell all others
      // that the database is being read
      if (readerCount == 1)
         dbReading = true;
     
      return readerCount;
   }

   // reader will call this when they finish reading
   public synchronized int endRead()
   { 
      --readerCount;

      // if I am the last reader tell all others
      // that the database is no longer being read
      if (readerCount == 0)
         dbReading = false;
      
      notifyAll();

	System.out.println("Reader Count = " + readerCount);

      return readerCount;
   }
   
   // writer will call this when they start writing
    public synchronized void startWrite()
   { 
      while (dbReading == true || dbWriting == true)
      {
         try { wait(); }
         catch(InterruptedException e) {}
      }

      // once there are either no readers or writers
      // indicate that the database is being written
      dbWriting = true;
   }

   // writer will call this when they start writing
   public synchronized void endWrite()
   { 
      dbWriting = false;

      notifyAll();
   }

   // the number of active readers
   private int readerCount;

   // flags to indicate whether the database is
   // being read or written
   private boolean dbReading;
   private boolean dbWriting;
   private Data data;
    
   private static final int NAP_TIME = 5;

    class Data {
	int elt1, elt2;
	Data(int pairElt1, int pairElt2){
	    elt1=pairElt1;
	    elt2=pairElt2;
	}
	int getElt1() {
	    return elt1;
	}
	int getElt2() {
	    return elt2;
	}
	void setElt1(int elt1){
	    this.elt1=elt1;
	}
	void setElt2(int elt2){
	    this.elt2=elt2;
	}
    }
}
