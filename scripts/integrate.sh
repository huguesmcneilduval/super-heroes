#!/bin/bash
tar -czf super-heroes-build-insertversionnumberhere.tar.gz \
docker-compose.yml makefile scripts \
super-heroes-backend/Dockerfile super-heroes-backend/target/superheroes-0.0.1-SNAPSHOT.jar \
super-heroes-frontend/Dockerfile super-heroes-frontend/build super-heroes-frontend/config
