#!/bin/bash

set -e

cd /backend
./mvnw package
./mvnw spring-boot:run
