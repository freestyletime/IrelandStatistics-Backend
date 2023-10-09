#!/bin/bash

start=$(date +"%s")

ssh ${SSH_USER}@${SSH_HOST} -i key.txt -t -t -o StrictHostKeyChecking=no << 'ENDSSH'
sudo docker pull ${DOCKERHUB_USERNAME}/ireland-statistics:latest

CONTAINER_NAME=application
if [ "$(sudo docker ps -qa -f name=$CONTAINER_NAME)" ]; then
if [ "$(sudo docker ps -qa -f name=$CONTAINER_NAME)" ]; then
    if [ "$(sudo docker ps -q -f name=$CONTAINER_NAME)" ]; then
        echo "Container is running -> stopping it..."
        sudo docker stop $CONTAINER_NAME;
    fi
fi

sudo docker run -d --rm -p 8081:8080 --name $CONTAINER_NAME ${DOCKERHUB_USERNAME}/ireland-statistics:latest --server.port=8080

exit
ENDSSH

if [ $? -eq 0 ]; then
  exit 0
else
  exit 1
fi

end=$(date +"%s")

diff=$(($end - $start))

echo "Deployed in : ${diff}s"