#!/bin/bash

set -e

cd /backend
./mvnw package
java -jar ./application/target/application-0.0.1-SNAPSHOT.jar
