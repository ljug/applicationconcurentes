# Concurrence, Parallélisme et E/S non bloquante 

Applications concurrentes et outils Java pour dans le cadre et en complément de la formation d'[ingénieur informatique](http://depinfo.isae.edu.lb) au [Cnam Liban](http://www.cnam-liban.fr).

La _**programmation concurrente**_ est un [paradigme de programmation](Paradigme/) tenant compte, dans un programme, de l'existence de plusieurs piles sémantiques qui peuvent être appelées **threads**, **processus** ou _tâches_. Elles sont matérialisées en machine par une pile d'exécution et un ensemble de données privées.

La concurrence est indispensable lorsque l'on souhaite écrire des programmes interagissant avec le monde réel (qui est concurrent) ou tirant parti de multiples unités centrales (couplées, comme dans un système multiprocesseurs, ou distribuées, éventuellement en grille ou en grappe). Afin de tirer profit des [architectures parallélisme](https://fr.wikipedia.org/wiki/Parall%C3%A9lisme_(informatique))

---
Dans ce dépôt nous traitons essentiellement de problèmes de concurrences (parallélisme d'exécution avec besoin d'utiliser des resources partagées) et leurs outils. On abordera les **'Lambda'** (pour les versions de Java à partir de Java 8) permettant certaines écritures plus adaptés ou plus élégantes.

Dans ce github vous trouverez un ensemble d'exemples pour mettre l'accent sur les problèmes lieés à la concurrence et leurs solutions d'une manière générale, au sein de la plateforme Java en particulier.

## Les Thread, Executors et autre outils de lancement de tâches concurrentes

* [La concurrence en java](/ConcurenceJava)

## La librairie java.util.concurent pour les outils de synchronisation.

# En complément du Cours ACCOV à l'[ISSAE Cnam Liban](http://depinfo.isae.edu.lb)

## Dont les Objectifs pédagogiques sont:

De par le développement des technologies Web, des langages de programmation concurrente, des outils de programmation réseau et celui des processeurs multi-cœurs, le calcul concurrent est aujourd'hui omniprésent dans la construction de systèmes comme les systèmes d'exploitation, les systèmes distribués et les systèmes temps réel. Cependant, la conception de tels systèmes et la preuve de leur correction sont des tâches très difficiles.
Ce cours a pour objectif :
- d'acquérir une connaissance pratique des "bons" patrons de la programmation concurrente (Java)
- de comprendre les problèmes fondamentaux des systèmes concurrents
- et de s'initier à des méthodes et techniques de vérification automatique de ces  systèmes (model-checking, logiques temporelles) 

Dan ce dépôt vous trouverez donc des exemples concernant cette partie du Cours

>>> Les paradigmes de la concurrence et les archétypes de programmation ('design patterns').
>>>>Exclusion mutuelle, élection, producteur consommateur, lecteurs rédacteurs, client-serveur, "peer to peer", problèmes liés aux pannes, diffusion atomique ordonnée, inter-blocage, famine, équité, terminaison.
Mécanismes de bases (processus, sémaphores, moniteurs, la classe "thread" et les méthodes "synchronized" dans Java, Executor, Lambda, communication synchrone et asynchrone, messages, boîtes aux lettres, invocation à distance, rendez-vous). Modularité et objets concurrents.

# Travaux pratique et compléments

## Autour du client/serveur TCP/IP

* [Introduction Socket](Complements/Sockets/)
* [Client/Serveur multi thread](ConcurenceJava/ClientServeurMultiT/)

# Autres références

* [Introduction aux problèmes liés à la concurrence](http://lps.cofares.net/ConcurenceEtSynchro/)

<iframe src="https://docs.google.com/presentation/d/e/2PACX-1vTFYyhZvdBAbS1Iq6a2BdfJElrI9FLycNDkAeCppEPvHTtgZoTE2kwPVhbx-jcodvfoMSnAx1VtgDz8/embed?start=false&loop=false&delayms=3000" frameborder="0" width="960" height="569" allowfullscreen="true" mozallowfullscreen="true" webkitallowfullscreen="true"></iframe>
