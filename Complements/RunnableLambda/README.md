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

Vous pourrez utiliser cette classe `ClassRunnable` pour créer autant de thread différents que vous souhaitez

```java
objectActivable = new Thread(new ClassRunnable());
```

et vous l'activerez par 
```java
objectActivable.start();
```
## Avec classe anonyme

Vous pouvez créer une implémentation en java sans être obligé de créer une classe nommé tou simplement en faisant

`new NomInterface() { .... le code de l'implémentation ....}`

Vous n'êtes donc pas obligé de créer une classe

```java
new Thread(new Runnable() { 
    public void run() {
             //.... le code de l'implémentation ....
    }
    });
```

## Une lambda

une fonction lambda représentant le `void run();`

`() -> { .... le code de l'implémentation .... }`

```java
new Thread(() -> {
             //.... le code de l'implémentation ....
    });
```

Voici les exemples en vidéo:

[![Alt text](https://img.youtube.com/vi/jT6AL5sAsW4/0.jpg)](https://www.youtube.com/watch?v=jT6AL5sAsW4)

<iframe width="560" height="315" src="https://www.youtube.com/embed/jT6AL5sAsW4" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
