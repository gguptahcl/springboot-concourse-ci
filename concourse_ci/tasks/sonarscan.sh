#!/bin/bash
#!/bin/sh

chmod +x concourse-ci/sonarscan.sh

set -e

echo ""
echo " .. Running build..."
echo "git url is... "
echo "${git_repo_url}"
echo "$(pwd)"
cd spring-boot-service
dir=$(pwd -P)
echo "The directory is "
echo $dir

./mvnw package --s settings.xml -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true -Dmaven.test.skip=true sonar:sonar -Dsonar.host.url=http://192.168.0.23:9000/ -Dsonar.verbose=true -Dsonar.projectKey=OmniChannelEcommerceHub-copy -Dsonar.projectName=OCH_EComm_Inventory_Service -Dsonar.exclusions=src/main/java/com/pepsico/**Factory.java,src/main/java/com/pepsico/**Constant.java,src/test/**,**.xml -Dsonar.java.binaries=target/classes

