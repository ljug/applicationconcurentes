# Objet actif

Le motif se compose de six éléments:

* Un proxy, qui fournit une interface vers les clients avec des méthodes accessibles publique.
* Une interface qui définit les méthodes disponible sur un objet actif.
* Une liste des demandes (appel) en attente des clients.
* Un ordonnanceur qui décide quelle requête exécuter ensuite.
* L'implémentation de la méthode de l'objet actif.
* Un rappel (callback) ou une variable permettant au client de recevoir le résultat.