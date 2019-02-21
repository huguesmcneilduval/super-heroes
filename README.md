# super-heroes


Il y a un Jenkins qui écoute sur la branche master et qui va déployer dans un docker sur l'url 
https://superheroes.philippeduval.ca

Le Jenkins en question est à l'url http://ovh.philippeduval.ca:8080, je vous donnerai des accès si vous voulez.

Les scripts de build/deploy sont d'abords sur Jenkinfile, qui utilise le makefile qui finalement démarre les scripts bash dans /scripts.

## Frontend
### Installation
```bash
cd super-heroes-frontend
npm install
``̀`

## Backend
### Installation
```bash
cd super-heroes-backend
mvn clean install
``̀`

## Swagger
url : https://superheroes.philippeduval.ca/api/swagger-ui.html#/
