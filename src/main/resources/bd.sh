#!/bin/bash

CONTAINER_NAME="test-nasa-db"
PASSWORD="123456789Aa!"
DATABASE_NAME="nasa"

while getopts c:p:d: flag
  do
    case "${flag}" in
      c) CONTAINER_NAME=${OPTARG};;
      p) PASSWORD=${OPTARG};;
      d) DATABASE_NAME=${OPTARG};;
    esac
  done

if ! docker stop $CONTAINER_NAME; then
  echo "Failed to stop container, probably it does not exist"
fi

if ! docker rm $CONTAINER_NAME; then
  echo "Failed to remove container, probably it does not exist"
fi

if ! docker run --name $CONTAINER_NAME -e POSTGRES_PASSWORD=$PASSWORD -d -p 5432:5432 postgres:latest; then
  echo "Failed to create container"
  exit 1
fi

echo "Container created successfully with password $PASSWORD"

echo "Waiting for container to start"
sleep 5

if ! docker exec "$CONTAINER_NAME" psql -U postgres -c "CREATE DATABASE $DATABASE_NAME;"; then
  echo "Failed to create database"
  exit 1
fi


echo "Database created successfully"