#!/bin/bash
HOST="root@superheroes.philippeduval.ca"
DIRECTORY="/var/app/superheroes.philippeduval.ca/"

scp super-heroes-build-insertversionnumberhere.tar.gz $HOST:$DIRECTORY

ssh $HOST "
pm2 reload superheroes.philippeduval.ca
"