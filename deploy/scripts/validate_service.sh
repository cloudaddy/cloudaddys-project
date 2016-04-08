#!/bin/bash

result=$(curl -s http://localhost:8080/)

if [[ "$result" =~ "Cloudaddy" ]]; then
    echo "Cloudaddy is up and running!";
    exit 0
else
    echo "Cloudaddy isn't up and running!";
    exit 1
fi
