# TP_4A_ESIEA_Tetris

BRAINVILLE Arthur, CLEMENT Vincent, GATTOLIN Nicolas

Build et lancement du programme :

mvn clean install && java -jar *.jar

Les features faites / ajoutés :

- toutes les fonctionnalités de la grille et des tetrominos
- boucle de jeu qui fait tomber les blocs
- vue de la grille

Un paragraphe expliquant comment jouer avec votre Tetris :

flèche gauche/droite : déplacer latéralament la pièce
flèche bas : faire descendre la pièce
s : rotation antihoraire
d : rotation horaire

L'exercice d'architecture :

Le pattern général utilisé pour l'architecture est le MVC: séparation Model (données) View (vues) Controler (lien entre vue et données, logique de l'application).
Nous avons respecté au mieux chacun des principes SOLID, meme si nous aurions pu écrire plus d'interfaces.
Un tétromino est représenté par les quatre positions de ses quatre blocs.
La grille est la seule à pouvoir modifier sa représentation interne. Une fonction permettant de "plaquer" un tetromino dans la grille permet d'afficher le tétromino courant sans modifier réellemnt la grille.
La class Game a pour responsabilité de mettre à jour le jeu tour par tour, c'est-à-dire :
- demander à la grille de faire tomber les pièces et de détruire les lignes complètes (le nombre de lignes détruites est retourné pour calculer le score),
- de choisir le prochain tétromino selon l'algorithme classique du Tétris,
- de gérer les deux joueurs et leurs scores associés


L'exercice Design Pattern / SOLID

- GameLoop http://gameprogrammingpatterns.com/game-loop.html :
pattern très courant pour la programmation de jeux, composé d'une boucle infinie et d'un timer qui appelle une fonction update mettant à jour l'état du jeu
- Observer : la vue est notifiée des changements du modèle (score et grille)
- Data Access Object : abstrait les ressources et offre une interface générique (DAO score)
- Iterator : permet l'itération générique sur une collection (implémenté pour itérer sur les blocs composant les tétrominos)
