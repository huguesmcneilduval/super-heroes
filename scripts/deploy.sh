#!/bin/bash
HOST="root@superheroes.philippeduval.ca"
DIRECTORY="/var/app/superheroes.philippeduval.ca/"
ARCHIVE="super-heroes-build-insertversionnumberhere.tar.gz"

scp super-heroes-build-insertversionnumberhere.tar.gz $HOST:$DIRECTORY

ssh $HOST "
cd $DIRECTORY
tar -xzf $ARCHIVE -C bin
pm2 reload superheroes.philippeduval.ca
"