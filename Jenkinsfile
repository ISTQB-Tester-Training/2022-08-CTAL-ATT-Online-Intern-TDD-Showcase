pipeline {
    agent any

    environment {
            SQ_TOKEN = credentials('Token-für-Zugriff-auf-SonarQube')
        }

    stages {
        stage('Build') {
            steps {

                git 'https://github.com/ISTQB-Tester-Training/2022-08-CTAL-ATT-Online-Intern-TDD-Showcase.git'

                sh "mvn compile"
            }
        }
        stage('Unit Test') {
            steps {

               sh "mvn test"
            }
        }
        stage('Code Analysis') {
            steps {

                sh "mvn verify sonar:sonar -Dsonar.host.url=http://80.158.7.52:30002 -Dsonar.login=$SQ_TOKEN"
            }
        }
    }
}