public  class Thermostat {

    private Object key =  new Object() ;

    // méthode statique synchronisée, le paramètre de synchronisation est
    // l'objet Thermostat.class
    public  static  synchronized  boolean getNombreThermostats() {
      
       // corps de la méthode
   }

    // méthode non statique synchronisée, le paramètre de synchronisation est
    // l'objet this
    public  synchronized  boolean plusChaud() {
      
       // corps de la méthode
   } 
   
    public  boolean plusFroid() {
      
       // synchronization sur l'objet key
       // on peut aussi synchroniser sur l'objet this
       synchronized(key) {
      
          // bloc synchronisé
      }
   }
}

