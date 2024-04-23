pipeline {
    agent any
    environment {
        IMAGE_VERSION = 'X.X.X'
    }
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
                env.IMAGE_VERSION = sh (returnStdout: true, script: "grep '^version=' ./target/maven-archiver/pom.properties | cut -d '=' -f 2")
            }
            steps {
                sh 'docker build -t edsonmendes/jenkins-study:${env.IMAGE_VERSION} -t edsonmendes/jenkins-study .'
            }
            post {
                success {
                    sh 'echo build image com sucesso!!!'
                }
                failure {
                    sh 'echo falhou em build image!!!'
                }
            }
        }
        stage('login dockerhub') {
            environment {
                DOCKERHUB_CREDENTIALS = credentials('edsonmendes-dockerhub')
            }
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
            post {
                failure {
                    sh 'echo falhou em logar no docker!!!'
                }
            }
        }
        stage('push image') {
            environment {
                DOCKERHUB_CREDENTIALS = credentials('edsonmendes-dockerhub')
            }
            steps {
                sh 'docker push edsonmendes/jenkins-study:${env.IMAGE_VERSION}'
                sh 'docker push edsonmendes/jenkins-study:latest'
            }
            post {
                always {
                    sh 'docker logout'
                }
                failure {
                    sh 'echo falhou em enviar imagem para docker hub!!'
                }
            }
        }
    }
}