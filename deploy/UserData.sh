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

# enable SSL model
echo '<?xml version="1.0" encoding="utf-8"?>
<Server port="8005" shutdown="SHUTDOWN">
<Listener className="org.apache.catalina.core.JasperListener" />
<Listener className="org.apache.catalina.core.JreMemoryLeakPreventionListener" />
<Listener className="org.apache.catalina.mbeans.GlobalResourcesLifecycleListener" />
<Listener className="org.apache.catalina.core.ThreadLocalLeakPreventionListener" />
<GlobalNamingResources>
<Resource name="UserDatabase" auth="Container"
type="org.apache.catalina.UserDatabase"
description="User database that can be updated and saved"
factory="org.apache.catalina.users.MemoryUserDatabaseFactory"
pathname="conf/tomcat-users.xml" />
</GlobalNamingResources>
<Service name="Catalina">
<Connector
port="8080"
protocol="HTTP/1.1"
proxyPort="443"
scheme="https"
secure="true"
proxyName="www.cloudaddy.us"
connectionTimeout="20000"
URIEncoding="UTF-8"
redirectPort="8443" />
<Engine name="Catalina" defaultHost="localhost">
<Realm className="org.apache.catalina.realm.LockOutRealm">
<Realm className="org.apache.catalina.realm.UserDatabaseRealm"
resourceName="UserDatabase"/>
</Realm>
<Host name="localhost"  appBase="webapps"
unpackWARs="true" autoDeploy="true">
<Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
prefix="localhost_access_log." suffix=".txt"
pattern="%h %l %u %t &quot;%r&quot; %s %b" />
</Host>
</Engine>
</Service>
</Server>
' | sudo tee /var/lib/tomcat7/conf/server.xml

# delete the default page
sudo rm -rf /var/lib/tomcat7/webapps/ROOT
exit 0
