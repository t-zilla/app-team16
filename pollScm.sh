#!/bin/sh
#
# An example hook script to prepare a packed repository for use over
# dumb transports.
#
# To enable this hook, rename this file to "post-commit".

if [ -z "$1" ]; 
    then "USER has not been provided"
    exit 1
fi

if [ -z "$2" ]; then 
    echo "PASS has not been provided"
    exit 1
fi 

sudo docker cp ../app-team16 jenkins-master:/var/jenkins_home

# Connection data
# Host connection data
JENKINS_HOST=127.0.0.1
USER=$1
PASS=$2

# Required as some Jenkins build keep crumbs valid only inside the session.
COOKIE_JAR=/tmp/cookies

# Job data
JOB="app"
JOB_TOKEN="rebuild"

# Getting CSRF authentication crumb
CRUMB=`curl --user $USER:$PASS --cookie-jar $COOKIE_JAR "http://$JENKINS_HOST:8080/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,\":\",//crumb)"`

# Triggering build of task
curl -X POST --user $USER:$PASS --cookie $COOKIE_JAR -H "$CRUMB" "http://$JENKINS_HOST:8080/job/$JOB/build?token=$JOB_TOKEN"
