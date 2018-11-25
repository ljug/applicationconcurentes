# Quelques exercices Thread Java

## Ordonner des execution de Thread avec join (Ordonner Thread squelette)[001_OrdonnerThread/]

Soit un objet tâche, la tâche à pour rôle de réaliser un certain traitement (dans l'exercice c'est juste un printf) voir (Tache)[001_OrdonnerThread/Tache.java]

Le thread principal crée 3 threads à partir de Tache et les démarre dans “l’ordre” TA,TB,TC. Vous créez un Thread TX ainsi `new Thread(new Tache(X), "TX")`

* *Question 1)* Adapter tache pour créer le Runnable avec paramètre du nom du runnable.

* *Question 2)* Créer la tache main qui va créer les trois Thread basé sur Tache TA,TB,TC

* *Question 3)* Modifier le code du constructeur de la classe Tache pour qu’il prenne en plus en paramètre une liste de 0 ou 1 threads à attendre, alternativement définir une méthode set_predecesseur(Thread t) qui permet de définir le prédécesseur d’un Thread "Tache".
* *Question 4)* Construire TC pour qu’il n’attende personne (ie ∅).
Construire TB pour qu’il attende TC.
Construire TA pour qu’il attende TB.
Lancer les 3 threads et observer (tester).
* *Question 5)* Que ce passerait-il si on ajoutait un thread TD avec TD<TC et TA<TD ? développer la solution et observer

