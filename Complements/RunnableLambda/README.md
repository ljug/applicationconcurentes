# Runnable et interface fonctionnelle

Runnable est une interface, possédant une seule méthode `void run()`

L'interface Runnable est est conçue pour fournir un protocole commun (un moyen) aux objets qui souhaitent exécuter du code lorsqu'ils sont actifs. Runnable est implémenté par la classe Thread. Être actif signifie simplement qu'un thread a été démarré et n'a pas encore été arrêté.

Il y a deux étapes pour qu'un objets devienne actif

1. Le créé `objetRunnable = new Thread(Objet d'une ClassRunnable);`
2. Puis le démarré `objetRunnable.start()`

**Nous allons montrer les différentes manières de définir la `ClassRunnable`.**

## implémenter l'interface Runnable

```java
public class ClassRunnable implements Runnable {

    @Override
    public void run() {
        //Le code de votre objets 
        //qui s'exécutera lorqu'il sera actif
    }

}
```

Vous pourrez utiliser cette classe `ClassRunnable` pour créer autant de thread différents que vous souhaiter

```java
objectActivable = new Thread(new ClassRunnable());
```

et vous l'activerez par 
```java
objectActivable.start();
```

Voici un exemple:
