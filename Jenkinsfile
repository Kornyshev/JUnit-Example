pipeline {
    agent any

    tools {
        maven 'Maven'
    }
    
    parameters {
        choice(name: 'Choice', choices: ['option'], description: 'Description')
    }


    stages {
        stage('Checkout from GitHub') {
            steps {
                echo "Parameter from job UI: ${params.Choice}"
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/Kornyshev/JUnit-Example']]
                ])
            }
        }

        stage('Run Maven Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}
