#!/bin/bash
validate(){
  result=$(curl -s http://localhost:8080/)

  if [[ "$result" =~ "Cloudaddy" ]]; then
      echo "Cloudaddy is up and running!";
      return 0
    else
      echo "Cloudaddy isn't up and running!";
      return 1
  fi
}

n=0
until [ $n -ge 5 ]
do
  validate && exit 0  # substitute your command here
  n=$[$n+1]
  sleep 30s
  echo "Retrying..."
done

echo "Failed after $n times of retrying."

exit 1
