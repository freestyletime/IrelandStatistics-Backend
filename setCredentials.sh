#!/bin/bash

MONGO_DATABASE=$1
MONGO_USER=$2
MONGO_PSWD=$3
MONGO_CLUSTER=$4

sed -i -e "s/\${MONGO_DATABASE}/${MONGO_DATABASE}/" $5
sed -i -e "s/\${MONGO_USER}/${MONGO_USER}/" $5
sed -i -e "s/\${MONGO_PSWD}/${MONGO_PSWD}/" $5
sed -i -e "s/\${MONGO_CLUSTER}/${MONGO_CLUSTER}/" $5