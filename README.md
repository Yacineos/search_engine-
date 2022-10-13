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

![0CF35F8D-173C-4C00-A2DE-9289F1C47B9D.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9cafd41c-5c4c-4b60-a289-2cacda9d52ae/0CF35F8D-173C-4C00-A2DE-9289F1C47B9D.png)

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
