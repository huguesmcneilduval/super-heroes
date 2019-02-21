#!/bin/bash
set -e
cd super-heroes-backend
mvn -Dmaven.test.skip=true clean install
