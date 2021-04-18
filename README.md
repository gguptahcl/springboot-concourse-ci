1) Start docker Desktop 

2) Start Local Concourse ci

    cd  C:\java_learning\concourse-ci
	docker-compose up -d

3) Start Local Sonar Server
	
	cd C:\java_learning\sonarqube-8.8.0.42792\bin\windows-x86-64
	startSonar.bat
	go to http://localhost:9000


4) 
		cd C:\java_learning\spring_ms\28mins-workspace\springboot-concourse-ci
		fly -t tutorial login -c http://localhost:8080 -u admin -p admin
		fly -t tutorial set-pipeline -p spring-boot-service -c concourse_ci/pipeline.yml -l concourse_ci/config.yml
		fly -t tutorial unpause-pipeline -p spring-boot-service
		
		http://localhost:8080