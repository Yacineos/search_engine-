## Bienvenue sur le projet logiciel INF353



## Semaine du 05/10

### Objectifs de la semaine et répartition

#### Objectif de la semaine :
Créer la classe DictionnaireNaif() et réussir les tests.

#### Organisation :
Réflexion :

* En premier lieu , on s’est regroupé afin de discuter de la classe dictionnaireNaif et de la spécification de ses méthodes, notamment de son constructeur. On a eu plusieurs idées de la représentation du dictionnaire, mais on s’est rabattu sur une représentation d’un tableau de chaîne de caractères ( String ) .

Répartition des tâches :

* On s’est divisé en 2 groupes: un groupe de test composé de Messipsa et Yacine, et un groupe de programmation composé d’Andy , Angeline , Sara et Basma . Dans le groupe de programmation, nous avions chacun fait deux méthodes, seul, mais ça n’a pas empêché la communication entre nous .

Réalisation :

* Chacun occupe un poste individuel .
* À la fin de la séance, chaque membre du groupe de programmation a envoyé ses deux méthodes par mail à Yacine qui les a ensuite regroupé dans une seule classe.
* La classe de test n’a pas été faite mais les différents cas ont été discuté et écris sur un bloc note.

### Récapitulatif :

Nous n’avons pas pu avoir une classe DictionnaireNaif fonctionnel , et nous n’avons pas pu passer les tests car on avait pas fini la classe de test. On aurait du faire des tests individuel de toutes les méthodes avant de tout regrouper sur une seul machine , et on aurait pu faire un projet qui compile avec une classe de test .

### Objectif de la semaine prochaine :

Mieux cerner le problème , et définir une spécification exacte du constructeur et des méthodes , pour éviter de partir sur une mauvaise base , et de perdre du temps .

-------------------------------------------------------------------
## Semaine du 12/10

Manipuler git afin de se familiariser avec, et finaliser notre classe DictionnaireNaif.

## Organisation :

Réflexion :

* Yacine a organisé un meeting sur discord afin que nous installons tous git sur nos PC, et que nous commençons à le manipuler chez nous.
* De plus nous avons enfin trouvé la bonne représentation du tableau :

https://drive.google.com/file/d/1biegN79pR9d3GdPkiIIpQSiBzhw9AGNO/view?usp=sharing

L’exemple est fait avec 10 caractères pour un mot mais dans le projet on a 40 caractères . Nous avons aussi, pendant ce meeting, réalisé la méthode IndiceMot() mais on s’est rendu compte après quelle était pas fonctionnelle .

Répartition des tâches :

* Les méthodes IndiceMot() et Vider() étant déjà faite, Yacine nous a attribué à chacun de nous une tâche à faire avant la séance de TP:
* Andy devait faire la méthode motIndice()
* Angeline devait faire la méthode nbMots()
* Basma et Sara devaient faire la méthode ajouterMot()
* Messipsa devait faire les tests de la classe.

Réalisation :

* On a chacun de nous télécharger git sur nos PC, chez nous, pour pouvoir travailler à la maison. Il y a eu des péripéties mais elles sont maintenant résolus pour chacun de nous. (Merci à Yacine)
* On a fait plusieurs meeting sur discord, pour discuter des problèmes rencontrés pendant l’installation du git, et pendant la réalisation de nos méthodes. (Certains avaient mal compris la représentation du dictionnaire, et d’autres n’avaient toujours pas installé git sur leur PC)
* Certains ont eu du mal à manipuler git, plusieurs jours avant la séance de TP, le terminal envoyait des messages d’erreur lorsqu’ils voulaient « push » un fichier.
* Le jour de TP, on a manipulé git sur les PC de l’établissement ensemble, tout en essayant de tester les méthodes (de la classe DictionnaireNaif) que chacun à fait. Chacun seul sur un PC, mais on communiquait tout de même entre nous.
* On a d’abord rencontré un problème pour compiler notre classe Main (On l’a compilé à partir d’un mauvais répertoire). Le problème est maintenant résolu.
* On a testé nos méthodes avec nos main, certains semblaient fonctionner, d’autre non, mais on a pu les corriger.
* Pendant ce temps Messipsa attendait de pouvoir tester nos méthodes.
* Nous avons ainsi fait plusieurs « git push » etc… on a rencontré quelque conflit souvent lié au fait de ne pas avoir la dernière version du projet et de faire des modifications et essayer de push , mais on a pu les corriger après .
* Puis nous avons rencontré un problème à la fin de la séance, lorsqu’on a voulu faire « git pull », on rencontrait toujours un problème, à cause nos main… en effet nous avions tous un main pour chacun de nous. Malheureusement quelqu’un a push tout un répertoire ce qui a modifié tous les autres main.

## Récapitulatif :

* Les méthodes les plus importantes semblent enfin réalisé. Il reste maintenant plus qu’à les tester avec les jeux de tests que Messipsa a fait.
* Nous avons manipulé git, avec succès disons…
* Aussi lorsque l’on fait un push le mieux serait de push seulement le fichier qu’on a modifié et non tout un répertoire.   

## Objectif de la semaine prochaine :

* Encore mieux se familiariser avec git, et réfléchir à deux fois avant de push un ficher dans le projet.


-----------------------------------------------------------------------------------
## semaine du 02/11
## **Objectif de la semaine**:

Finaliser les classes Recherche, MatriceIndexNaive, LecteurDocumentNaif et Indexation.

## **Organisation :**

Réflexion :

* Discussion sur la compréhension du sujet et des classes et méthodes à créer.
* Nous avons relu le cours pour comprendre les notions d’Indexation et Recherche.

Répartition des tâches :

* Sara & Andy : Création de la classe MatriceIndexNaive
* Angeline & Basma : Création des classes LecteurDocumentNaif et Indexation.
* Yacine & Messipsa : Création de la classe Recherche.

Réalisation :

* Chaque binôme a réalisé de son côté la classe qui lui était associé.
* Sara et Andy avait fini leur classe et donc ce sont séparées pour aller aider les deux autres binômes sur la réalisation des classes restantes.
* Chaque binôme a créé sa classe Main pour tester les méthodes. Certaines semblaient fonctionner, d’autre non, mais on a pu les corriger.
* Le jour de TP, nous avons eu un gros problème au niveau de la lecture du fichier car le fichier ne situait pas au même endroit chez tout le monde(problème de répertoire). Cela nous a pris beaucoup de temps pour essayer de trouver une solution.
* Pendant ce temps Andy a créé la méthode lecteurDictionnaire(). Messipsa quant à lui, a dessiné et réfléchit à la création de la méthode calculDocPlusPertinent().
* Le lendemain, Yacine, Basma et Angeline après mainte recherche ont trouvé la solution à ce problème.

## **Récapitulatif :**

* Les méthodes les plus importantes semblent enfin réalisé. Il reste maintenant plus qu’à finaliser la classe de Recherche.

## **Objectif de la semaine prochaine :**

* Organiser un meeting pour faire un récapitulatif des méthodes manquantes.
* Finalisation du TP.


---------------------------------------------------------------------------------------------
## semaine du 17/11
## **Objectif de la semaine**:

Finaliser les classes Recherche , Indexation et avoir une première version qui marche , lire et comprendre d’autres méthodes qui peuvent améliorer le résulatat obtenu

## **Organisation :**

Réflexion :

* Discussion sur l’implémentation de la classe indexation et Recherche et comment utiliser les différentes méthodes .

Répartition des tâches :

* Sara & Basma & Angeline : Réalisation de la class Indexation .
* Yacine & Messipsa & Andy : Réalisation de la class Recherche.

Réalisation :

* Chaque trinôme a réalisé de son côté la classe qui lui était associé.
* Pour réaliser la classe Indexation, nous avions d’abord besoin de réaliser la classe LecteurDocumentNaif (fait par Angeline et Basma) et la classe MatrixIndexNaive (fait par Sara et Andy).  Puis nous avions décidé de faire un constructeur pour la classe Indexation qui devra créer les dictionnaires et les sauver. Ainsi Basma s’est chargé de faire les méthodes qui crée et remplit les dictionnaires, Sara s’est chargé de faire les méthodes qui sauvent les documents et Angeline s’est chargé de faire les tests.
* Yacine a crée la méthode de lecture de la requête quant à Messipsa il a pensé à un algorithme pour le calcul de pertinence , avec l’aide de Yacine et Andy a réussi à le mettre en oeuvre .
* on a refait une réunion pour discuter de l’état d’avancement du projet et des difficultés et/ou des bugs rencontré lors de la réalisation .

## **Récapitulatif :**

* On a abouti à une première version du projet qui marche mais pour augementer sa fiabilité on essayera de faire des tests unitaire .

## **Objectif de la semaine prochaine :**

* Utiliser a méthode Scrum agile , faire des meetings chaque 1 ou 2 jours de 15min , et faire un grand récapitulatif le jeudi.
* découvrir les possibilités d’optimisation du moteur recherche afin d’avoir des résultats plus affinés.