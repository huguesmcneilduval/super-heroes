pipeline {
    agent any

    stages {
        stage('Build frontend') {
            steps {
                sh "make buildFrontend"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
