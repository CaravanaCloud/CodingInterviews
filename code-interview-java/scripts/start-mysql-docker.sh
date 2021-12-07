#!/bin/bash

docker run --rm -ti \
    --name mysql \
    -p 0.0.0.0:3306:3306 \
    -e MYSQL_ROOT_PASSWORD=Masterkey123 \
    -e MYSQL_DATABASE=shakila \
    -v /var/lib/mysql:/var/lib/mysql \
    mysql:latest

# mysql -h127.0.0.1 -uroot -pMasterkey123 shakila