pipeline {
    agent any
    stages {
        stage('package') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('unit test') {
            steps {
                sh 'mvn test -P unit-tests'
            }
            post {
                always {
                    sh 'echo unit test stage finished'
                }
            }
        }
        stage('integration test') {
            steps {
                sh 'mvn test -P integration-tests'
            }
            post {
                always {
                    sh 'echo integration test stage finished'
                }
            }
        }
        stage('build image') {
            steps {
                sh 'docker build -t edsonmendes/jenkins-study .'
            }
            post {
                success {
                    sh 'echo executou docker com sucesso!!!'
                }
                failure {
                    sh 'echo falhou em executar o docker!!!'
                }
            }
        }
    }
}