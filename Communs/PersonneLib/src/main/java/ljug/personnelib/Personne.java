package ljug.personnelib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pfares
 */
public class Personne {
  private String nom;
  private String prenom;
  private int age;
  private Genre genre;
  private String eMail;
  private String telephone;
  private String addresse;
  
  public static class Builder{
    
    private String nom="";
    private String prenom="";
    private int age = 0;
    private Genre genre = Genre.INCONNU;
    private String eMail = "";
    private String telephone = "";
    private String addresse = "";
       
    public Personne.Builder nom(String Nom){
      this.nom = Nom;
      return this;
    }
    
    public Personne.Builder prenom(String prenom){
      this.prenom = prenom;
      return this;
    }
    
    public Personne.Builder age (int val){
      age = val;
      return this;
    }
    
    public Personne.Builder genre(Genre val){
      genre = val;
      return this;
    }
    
    public Personne.Builder email(String val){
      eMail = val;
      return this;
    }
    
    public Personne.Builder numTel(String val){
      telephone = val;
      return this;
    }
    
    public Personne.Builder addresse(String val){
      addresse = val;
      return this;
    }
    
    public Personne build(){
      return new Personne(this);
    }
  }
    
  private Personne(){
    super();
  }
    
  private Personne(Personne.Builder builder){
    nom = builder.nom;
    prenom = builder.prenom;
    age = builder.age;
    genre = builder.genre;
    eMail = builder.eMail;
    telephone = builder.telephone;
    addresse = builder.addresse;
        
  }
  
  public String getNom(){
    return nom;
  }
  
  public String getPrenom(){
    return prenom;
  }
  
  public int getAge(){
    return age;
  }
            
  public void print(){
    System.out.println("\nName: " + nom + " " + prenom + "\n" + 
      "Age: " + age + "\n" +
      "Gender: " + genre + "\n" + 
      "eMail: " + eMail + "\n" + 
      "Phone: " + telephone + "\n" +
      "Address: " + addresse + "\n"
                );
  } 
  
  public void printNomComplet(){    
    System.out.println("Name: " + nom + " " + prenom);
  }

  @Override
  public String toString(){
    return "Name: " + nom + " " + prenom + "\n" + "Age: " + age + "  Gender: " + genre + "\n" + "eMail: " + eMail + "\n" + "Address: " + addresse + "\n";
  } 
  

  public static List<Personne> createShortList(){
    List<Personne> people = new ArrayList<>();
    
    people.add(new Personne.Builder()
            .nom("Pascal")
            .prenom("Fares")
            .age(21)
            .genre(Genre.HOMME)
            .email("pascal.fares@cofares.net")
            .numTel("201-121-4678")
            .addresse("44 4th St, UneVille, KS 12333")
            .build() 
      );
    
    people.add(new Personne.Builder()
            .nom("Léa")
            .prenom("Fares")
            .age(25)
            .genre(Genre.FEMME)
            .email("lea.fares@cofares.net")
            .numTel("202-123-4678")
            .addresse("33 3rd St, UneVille, KS 12333")
            .build() 
      );
    
    people.add(new Personne.Builder()
            .nom("Emile")
            .prenom("Ami")
            .age(25)
            .genre(Genre.HOMME)
            .email("emile.ami@cofares.net")
            .numTel("202-123-4678")
            .addresse("33 3rd St, UneVille, KS 12333")
            .build()
    );
    
    people.add(new Personne.Builder()
            .nom("James")
            .prenom("Johnson")
            .age(45)
            .genre(Genre.HOMME)
            .email("james.johnson@cofares.net")
            .numTel("333-456-1233")
            .addresse("201 2nd St, New York, NY 12111")
            .build()
    );
    
    people.add(new Personne.Builder()
            .nom("Joe")
            .prenom("Bailey")
            .age(67)
            .genre(Genre.HOMME)
            .email("joepascal.bailey@cofares.net")
            .numTel("112-111-1111")
            .addresse("111 1st St, Ville, CA 11111")
            .build()
    );
    
    people.add(new Personne.Builder()
            .nom("Phil")
            .prenom("Smith")
            .age(55)
            .genre(Genre.HOMME)
            .email("phil.smith@examp;e.com")
            .numTel("222-33-1234")
            .addresse("22 2nd St, Village, CO 222333")
            .build()
    );
    
    people.add(new Personne.Builder()
            .nom("Betty")
            .prenom("Jones")
            .age(85)
            .genre(Genre.FEMME)
            .email("betty.jones@cofares.net")
            .numTel("211-33-1234")
            .addresse("22 4th St, Village, CO 222333")
            .build()
    );
    
    
    return people;
  }
  
}
