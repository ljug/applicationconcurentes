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
       //Thread.yield(); // to force problems in case not well synchronized
       int sleepTime = (int) (NAP_TIME * Math.random() );
       try { Thread.sleep(sleepTime*1000); } 
       catch(InterruptedException e) {}
       data.setElt2(elt2);
   }


   // reader will call this when they start reading
   public int startRead()
   { 
	return 0 ; // pour que cela compile
   }

   // reader will call this when they finish reading
   public int endRead()
   { 
	return 0; // pour que cela compile
   }
   
   // writer will call this when they start writing
    public void startWrite()
   { 
   }

   // writer will call this when they start writing
   public  void endWrite()
   { 
   }

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
