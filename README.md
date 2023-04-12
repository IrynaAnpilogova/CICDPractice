# Start Jenkins
```
JENKINS_HOME=$PWD/home JAVA_HOME=$PWD/Java ./Java/bin/java -jar jenkins.war
```

# Run SMEE proxy
Create new channel at https://smee.io/ and run local proxy:
```
# Install smee client:
npm install --global smee-client

# Run local proxy and forward all calls to Jenkins on localhost
smee -u https://smee.io/ohwYwg85jYHUmIkV -t http://localhost:8080/github-webhook/
```

# Build App Docker image
```
cd App
docker build -t app-image .
```

# Build Tests Docker Image
```
cd AppTests
docker build -t tests-image .
```

# Pull Selenium Docker image
```
docker pull selenium/standalone-chrome
```

# Start App container
App container is named `my-app`. Internal container port 80 is mapped to outside 8081 port.
App can be accesed on port 8081 of this container.
```
docker run -d --rm -p 8081:80 --name my-app app-image
```

# Start Selenium Container
```
docker run -d --rm -p 4444:4444 --link my-app:my-app --name my-selenium selenium/standalone-chrome
```

# Run Tests container
```
docker run -it --link my-selenium:my-selenium -v ${PWD}/AppTests:/data tests-image mvn clean test
```

# Archive test report

# Stop docker containers
```
docker stop my-app my-selenium
```
