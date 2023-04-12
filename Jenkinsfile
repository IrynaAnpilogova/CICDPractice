pipeline {
    agent any

    stages {
        stage('Build Docker images') {
            steps {
                sh '''cd App &&
                docker build -t app-image . &&
                cd ../AppTests &&
                docker build -t tests-image . &&
                docker pull selenium/standalone-chrome
                '''
            }
        }
        stage('Start containers') {
            steps {
                sh '''docker stop my-app my-selenium &&
                docker run -d --rm -p 8081:80 --name my-app app-image &&
                docker run -d --rm -p 4444:4444 --link my-app:my-app --name my-selenium selenium/standalone-chrome
                '''
            }
        }
        stage('Run tests') {
            steps {
                sh '''
                docker run --link my-selenium:my-selenium -v ${PWD}/AppTests:/data tests-image mvn clean test
                '''
                // Archive test report
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
        post { 
            cleanup { 
                steps {
                    sh 'docker stop my-app my-selenium'
                }
            }
        }
    }
}
