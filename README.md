# OC_Project_6: Les amis de l'escalade.  

  
  

## Table of contents 
* [Informations générales](#général) 
* [Technologies utilisées](#technologies) 
* [configuration de la base de données](#bdd) 
* [Déploiement de l'application sur Tomcat](#déploiement) 

## Informations générales :  

### Non de l'application  

Les amis de l'escalade 

### Description  

Il s'agit d'un site communautaire qui réunit les passionnés d'escalade. Les utilisateurs peuvent y trouver des informations concernant différents sites de grimpes. Ils pourront chercher un site de grimpe en fonction de différents paramètres par le biais d'un filtre de recherche et commenter les sites. 

Les utilisateurs connectés peuvent proposer des topos à d'autres utilisateurs connectés également. Ces derniers pourront faire une demande de réservation qui sera validée ou non par le propriétaire du topo. 

Le site se veut responsive et est adapté à tout type d'écran. 

## Technologies utilisées : 

* Java 13.0.1.  
* Hibernate version 5.4.9.Final 
* Maven 4.0.0 
* Bootstrap 4  

## Configuration de la base de données : 

* Type: Mysql
* Nom du schéma : escalade_db 
* N° du port 3306 
* Identifiant : root 
* Mot de passe : root 

Il n'est pas nécessaire de créer les tables dans le schéma escalade_db, l'application se charge de créer les tables lorsque celle-ci est lancée. 

## Déploiement de l'application sur tomcat : 

### Installation de Tomcat 

1- Récupérer la dernière version de [tomcat](https://tomcat.apache.org/download-90.cgi) compatible avec votre système d'exploitation. 
2- Récupérer le fichier compressé et le décompressé à la racine de votre ordinateur. 

### Déploiement du war 

1- Lancer l'invité de commande.  
2- Se rendre dans le dossier bin de Tomcat et exécuter la commande suivante : catalina.bat start 
3- Récupérer le numéro du port sur lequel a été lancé le serveur Tomcat. 
4- Ouvrir votre navigateur et tapez l'url suivante : 
http://localhost:numeroduport/amis_de_l'escalade/ 