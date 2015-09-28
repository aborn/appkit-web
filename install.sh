#!/usr/bin/env bash

# compile first
mvn compile

# package war
mvn package -Dmaven.test.skip=ture

# remove old file
rm -rf ~/software/apache-tomcat-7.0.61/webapps/appkit-web

# use new war files
cp -r target/appkit-web ~/software/apache-tomcat-7.0.61/webapps/

# stop tomcat and start it
# ~/software/apache-tomcat-7.0.61/bin/catalina.sh stop
kill -9 `ps -ef |grep tomcat|grep -v grep|awk '{print $2}'`
~/software/apache-tomcat-7.0.61/bin/catalina.sh start


