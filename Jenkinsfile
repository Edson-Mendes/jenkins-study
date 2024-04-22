pipeline {
    agent any
    stages {
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
        stage('package') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('build image') {
            environment {
                IMAGE_VERSION = sh (returnStdout: true, script: "grep '^version=' ./target/maven-archiver/pom.properties | cut -d '=' -f 2")
            }
            steps {
//                 sh 'docker build -t edsonmendes/jenkins-study .'
                   sh 'echo $IMAGE_VERSION'
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