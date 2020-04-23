# Producteur / Consommateur
## L'exemple cubyhole

[CubyHole exemple](https://github.com/ljug/applicationconcurentes/tree/master/ConcurenceJava/Patterns/ProducteursConsomateurs/ProdConsCubyHole/src/main/java/net/cofares/cubyhole) : d'un tampon d'un seul élément synchronisation par moniteur java synchronized/wait/notifyAll

## Un cubyhole avec implémentation de commandes gardées et tampon de taille plafonné

une garde est une expression de type booléen (proposition) qui a pour valeur vrai si l'exécution du programme doit continuer dans la branche en question.

`garde → { actions }`

Dans un paradigme de commandes gardée, plusieurs gardes peuvent êtres activés de manières concurrentes. 
Celle dont la garde est vraie l’action associé est exécuté, sinon elle est en attente.

### une implementation en Java

[L'exemple complet avec implémentation par garde](https://github.com/ljug/applicationconcurentes/tree/master/ConcurenceJava/Patterns/ProducteursConsomateurs/PCCHGarde2)

Voici une implémentation de la notion de gardes, probablement on peut faire mieux, mais c'est juste pour en faire un exemple por utiliser le principe.

```java
/**
 * La classe Garde un moniteur sur un propriété
 * garde() : when(propriete)
 * notgarde() : when(not proprieteé)
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Garde {

    private boolean garde;

    public Garde(boolean g) {
        //On initialise la garde
        garde = g;
    }
    /**
     * @return the garde
     */
    private synchronized boolean isGarde() {
        return garde;
    }

    //when (C)
    public synchronized void garde() {
        while (!isGarde()) try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Garde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //when( not C)
    public synchronized void notGarde() {
        while (isGarde()) try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Garde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Demande de modification la valeur de la garde
     * Si modifiée notifier les gardes en attente
     * @param garde the garde to set
     */
    public synchronized void setGarde(boolean garde) {
        //vérifier si la valeur de la garde a changé
        //Si oui faire notifyAll
        if (this.garde != garde) {
            this.garde = garde;
            notifyAll();
            
        }
        
    }

}
```

