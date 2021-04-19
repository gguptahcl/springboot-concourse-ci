#!/bin/bash

set -e

echo "Starting unit tests...."
cd spring-boot-service


ls -lt
chmod +x concourse_ci/tasks/unittest.sh
chmod +x ./mvnw


echo "$(pwd)"
# ./mvnw test --s settings.xml -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true