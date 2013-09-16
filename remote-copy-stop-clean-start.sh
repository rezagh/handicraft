#!/bin/bash

# You must setup public/private keys between the two machines.
# also need to export java_home in the dest scripts when start/stopping tomcat

war=handicraft.war
dest=vpsrezas3cret@74.207.244.238
keep_dir=wars

echo -- copy the war file to destination
scp $war $dest:/home/vpsrezas3cret/$keep_dir

echo -- stop tomcat
ssh $dest /home/vpsrezas3cret/scripts/stop-tomcat-apache

echo -- mkdir $keep_dir
ssh $dest mkdir /home/vpsrezas3cret/$keep_dir

echo -- copy the war file to tomcat
ssh $dest cp /home/vpsrezas3cret/$keep_dir/$war /home/vpsrezas3cret/java/tomcat/webapps/

echo -- rename and label the CURRENT war file and keep in $keep_dir folder
ssh $dest mv /home/vpsrezas3cret/$keep_dir/$war /home/vpsrezas3cret/$keep_dir/$war-$(date +%Y-%m-%d-%H-%M-%S)

echo -- clean handicraft tomcat
ssh $dest /home/vpsrezas3cret/scripts/clean-handicraft-tomcat.sh

echo -- start tomcat
ssh $dest /home/vpsrezas3cret/scripts/start-tomcat-apache

echo -- server status
ssh $dest /home/vpsrezas3cret/scripts/server-status

echo -- ALL DONE.