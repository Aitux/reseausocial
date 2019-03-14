# Squelette pour MIAGE BOOK

Voila une squelette d'application que vous pouvez utiliser pour
demarrer votre projet MiageBook.

## Instruction

Il s'agit d'un projet maven, il suffit de lancer

	mvn package

pour tour compiler. Il génère un fichier .war qu'il faut deployer sur
le web server (Glassfish ou Tomcat).

Attention, le bon fonctionnement a été validé avec Glassfish.

Une fois deployé, il faut lancer l'application de l'interface du web
server.

## Execution 

L'application est disponible sur la root:

   http://localhost:8080/LoginPage

Les ressources disponibles sont les suivants:

1) Une servlet. La classe se trouve dans LoginPage.java, et ça
   correspond à l'adresse:

   http://localhost:8080/LoginPage/hello

   (voir dans le fichier WEB-INF/web.xml)


2) Une jsp, dans le fichier myindex.jsp, et ça corresponds à l'adresse:

   http://localhost:8080/LoginPage/myindex.jsp


3) Une ressource REST, dans le fichier MyResource.java, et ça
   correspond à l'adresse :

   http://localhost:8080/LoginPage/rest/myresource

   (voir la correspondance dans le fichier ApplicationConfig.java)

