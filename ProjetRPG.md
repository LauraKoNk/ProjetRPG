# ProjetRPG

Read me de Laura Kokonyange-Nkasei - Projet RPG JAVA LPWM

## Description :

Ce projet est un jeu de rôle (RPG) simple écrit en Java. L'objectif est de permettre aux joueurs d'explorer un monde fantastique, d'acheter des armes, de combattre des monstres et de surmonter des obstacles.

## **Fonctionnalités :**

- **Création du personnage :** Les joueurs peuvent créer leur personnage en entrant un nom.
- **Achat d'armes :** Les joueurs peuvent acheter des armes dans un magasin.
- **Combats :** Les joueurs peuvent combattre des monstres et surmonter des obstacles.
- **Changement d'arme :** Les joueurs peuvent changer d'arme pendant les combats.

## Les classes :

> classe **Player :** Représente le joueur et personnage principal du jeu RPG, gère ses actions telles que l'achat d'armes, le changement d'arme et les combats.
> 

### **Attributs**

- **`name`** : Le nom du joueur.
- **`weapons`** : Une liste d'armes que le joueur possède.
- **`money`** : La quantité d'argent disponible pour le joueur.
- **`damage`** : Les dégâts infligés par le joueur.
- **`currentWeapon`** : L'arme actuellement équipée par le joueur.

### **Méthodes**

### **`Player(String name)`**

Le constructeur initialise un joueur avec un nom donné, une quantité d'argent de départ (50$), une vie maximale (100 HP), et une liste d'armes vide.

### **`getName() : String`**

Retourne le nom du joueur.

### **`isDead() : boolean`**

Vérifie si la vie du joueur est égale ou inférieure à zéro, indiquant ainsi si le joueur est mort.

### **`getWeapons() : ArrayList<Weapon>`**

Retourne une copie de la liste d'armes actuellement possédées par le joueur.

### **`getMoney() : double`**

Retourne la quantité d'argent actuellement détenue par le joueur.

### **`buyWeapon(Weapon w) : void`**

Permet au joueur d'acheter une arme donnée, déduisant le coût de l'arme de son argent total.

### **`displayWeapons() : void`**

Affiche les armes actuellement possédées par le joueur.

### **`attackMonster(Monster targetMonster) : void`**

Effectue une attaque sur un monstre donné, infligeant des dégâts et vérifiant si le monstre est vaincu.

### **`attackObstacle(Obstacle targetObstacle) : void`**

Effectue une attaque sur un obstacle donné, infligeant des dégâts et vérifiant si l'obstacle est vaincu.

### **`calculateDamage() : int`**

Calcule les dégâts infligés par le joueur, en prenant en compte une certaine variation aléatoire.

### **`getCurrentWeapon() : Weapon`**

Retourne l'arme actuellement équipée par le joueur.

### **`changeWeapon(Scanner scanner, WeaponStore store) : void`**

Permet au joueur de changer d'arme pendant un combat en affichant les armes disponibles et en permettant au joueur de choisir une nouvelle arme.

### **Remarques**

- Les dégâts infligés par le joueur sont calculés de manière aléatoire avec une certaine variation.
- Le joueur peut acheter des armes, les afficher, attaquer des monstres et des obstacles, et changer d'arme pendant le jeu.

---

> classe **Weapon :** Classe abstraite représentant une arme avec des sous-classes spécifiques telles que Axe, Bow, Hammer, etc. C’est une classe abstraite qui sert de base pour la création d'armes spécifiques dans le jeu RPG.
> 

## **Attributs**

- **`damage`** : Les dégâts infligés par l'arme.
- **`price`** : Le coût d'achat de l'arme.
- **`name`** : Le nom de l'arme.

## **Méthodes**

### **`Weapon(String name, double damage, double price)`**

Le constructeur initialise une arme avec un nom, des dégâts, et un prix donnés.

### **`getDamage() : double`**

Retourne la quantité de dégâts infligés par l'arme.

### **`getPrice() : double`**

Retourne le coût d'achat de l'arme.

### **`toString() : String`**

Retourne une représentation textuelle de l'arme, affichant le nom, le prix et les dégâts.

### **`ascii_art() : String`**

Méthode abstraite à implémenter par les sous-classes. Retourne une représentation graphique de l'arme sous forme de texte ASCII.

### **`getName() : String`**

Retourne le nom de l'arme.

## **Remarques**

- La classe **`Weapon`** est conçue pour être étendue par des sous-classes représentant des armes spécifiques telles que l'Axe, l'Arc, le Marteau, etc.
- Les détails spécifiques de chaque arme, tels que la représentation graphique ASCII, doivent être implémentés dans les sous-classes.

---

> classe **WeaponStore :** Stocke les armes disponibles pour l'achat. Elle représente un magasin d'armes dans le jeu RPG.
> 

## **Attributs**

- **`weaponsList`** : Une liste d'armes disponibles dans le magasin.

## **Méthodes**

### **`WeaponStore()`**

Le constructeur initialise le magasin avec une sélection initiale d'armes, comprenant un arc, une hache et un marteau.

### **`printWeaponsList() : void`**

Affiche la liste des armes disponibles dans le magasin, y compris leur représentation textuelle et graphique ASCII.

### **`getWeapon(int index) : Weapon`**

Retourne l'arme située à l'index spécifié dans la liste du magasin.

### **`getWeaponsCount() : int`**

Retourne le nombre total d'armes disponibles dans le magasin.

### **`isValidWeaponChoice(int index) : boolean`**

Vérifie si l'index fourni correspond à une arme valide dans la liste du magasin. Renvoie **`true`** si l'index est compris entre 0 (inclus) et le nombre total d'armes (exclus), sinon renvoie **`false`**.

## **Remarques**

- La classe **`WeaponStore`** fournit des méthodes pour afficher, obtenir et vérifier la validité du choix d'arme par le joueur.

---

> classe **Monster :** Représente un monstre que le joueur peut combattre dans le jeu RPG.
> 

## **Attributs**

- **`name`** : Le nom du monstre.
- **`damage`** : Les dégâts infligés par le monstre.
- **`HP`** : Les points de vie du monstre, initialisés à 100.

## **Méthodes**

### **`Monster(String name, int damage)`**

Le constructeur initialise un monstre avec un nom et des dégâts spécifiés, ainsi que la vie initiale du monstre (100 HP).

### **`attack(Player player) : void`**

Effectue une attaque sur le joueur, infligeant des dégâts et vérifiant si le joueur est vaincu.

### **`calculateDamage() : int`**

Calcule les dégâts infligés par le monstre, en prenant en compte une certaine variation aléatoire.

### **`isDead() : boolean`**

Vérifie si la vie du monstre est égale ou inférieure à zéro, indiquant ainsi si le monstre est mort.

### **Getters et Setters**

- **`getName() : String`** : Retourne le nom du monstre.
- **`setName(String name) : void`** : Modifie le nom du monstre.
- **`getDamage() : int`** : Retourne les dégâts infligés par le monstre.

## **Remarques**

- Les dégâts infligés par le monstre sont calculés de manière aléatoire en tenant compte d'un facteur de force aléatoire.
- La classe **`Monster`** fournit des méthodes pour attaquer le joueur, calculer les dégâts, vérifier si le monstre est mort, ainsi que des getters et setters pour les attributs.

---

> classe **Obstacle :** Représente un obstacle que le joueur peut surmonter.
> 

## **Attributs**

- **`name`** : Le nom de l'obstacle.
- **`HP`** : Les points de vie de l'obstacle, initialisés à 50.
- **`HP_VARIATION`** : La variation aléatoire des points de vie de l'obstacle, initialisée à 20.0.

## **Méthodes**

### **`Obstacle(String name)`**

Le constructeur initialise un obstacle avec un nom spécifié et des points de vie générés aléatoirement.

### **`generateRandomHP() : double`**

Génère de manière aléatoire les points de vie de l'obstacle en tenant compte d'une variation aléatoire.

### **`getName() : String`**

Retourne le nom de l'obstacle.

### **`setName(String name) : void`**

Modifie le nom de l'obstacle.

### **`isDead() : boolean`**

Vérifie si la vie de l'obstacle est égale ou inférieure à zéro, indiquant ainsi si l'obstacle est détruit.

## **Remarques**

- Les points de vie de l'obstacle sont générés de manière aléatoire avec une variation pour ajouter de la diversité.
- La classe **`Obstacle`** fournit des méthodes pour obtenir et modifier le nom de l'obstacle, ainsi que pour vérifier si l'obstacle est détruit.

---

> classe  **Destructible**  : représente une entité dans le jeu RPG qui peut subir des dégâts et a une certaine quantité de vie.
> 

## **Attributs**

- **`life`** : La vie de l'entité, initialement fixée à 100.

## **Méthodes**

### **`Destructible(double hp)`**

Le constructeur initialise l'entité avec une quantité de vie spécifiée.

### **`getLife() : double`**

Retourne la quantité actuelle de vie de l'entité.

### **`hit(double damage) : void`**

Applique les dégâts spécifiés à l'entité, réduisant sa vie en conséquence.

## **Remarques**

- La classe **`Destructible`** est conçue pour être étendue par des classes telles que **`Monster`**, **`Player`**, et **`Obstacle`**.
- Les entités qui étendent **`Destructible`** peuvent subir des dégâts en utilisant la méthode **`hit`**.

## **Mécanismes de combat :**

- Le joueur peut attaquer un monstre en choisissant l'action "attack".
- Le joueur peut changer d'arme pendant un combat en choisissant l'action "change weapon".
- Le joueur peut fuir un combat en choisissant l'action "run".

## **Comment jouer :**

1. Exécutez le programme.
2. Entrez le nom de votre personnage.
3. Explorez le magasin et achetez des armes.
4. Rencontrez aléatoirement des monstres ou des obstacles lors de vos déplacements.
5. Choisissez comment réagir à chaque rencontre (attaquer, changer d'arme, fuir).
6. Continuez à jouer jusqu'à ce que votre personnage soit vaincu ou que vous décidiez de mettre fin à l'aventure.

## ****Remarques****

- Les combats et les rencontres avec des monstres ou des obstacles sont générés de manière aléatoire pour plus de fun.