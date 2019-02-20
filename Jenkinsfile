pipeline {
    agent any

    stages {
        stage('Build frontend') {
            steps {
                sh "make buildFrontend"
            }
        }
        stage('Build backend') {
            steps {
                sh "make buildBackend"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Integrate') {
            steps {
                sh "make integrate"
            }
        }
        stage('Deploy') {
            steps {
                sh "make deploy"
            }
        }
    }
}
