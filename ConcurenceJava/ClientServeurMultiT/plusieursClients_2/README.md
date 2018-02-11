# version 2 avec Thread de service par client

Client boucle
 lit l'entrée standard
 envoie la ligen au serveur
 termine si la ligne = fin (envoie . au serveur)

Serveur accueille un client et lance une tache de traitement du client (service)


le service lire la ligne et la renvoie au client, quand "." termine le service

