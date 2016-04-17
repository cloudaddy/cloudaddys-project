#!/bin/bash -ex
# install awscli and CodeDeploy Agent
sudo apt-get -y update
sudo apt-get -y install awscli
sudo apt-get -y install ruby2.0
sudo apt-get -y install unzip
cd /home/ubuntu
aws s3 cp s3://aws-codedeploy-us-west-2/latest/install . --region us-west-2
chmod +x ./install
sudo ./install auto

# install tomcat and java
sudo apt-get -y install tomcat7

exit 0
