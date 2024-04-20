pipeline {
    agent any
    stages {
        stage('build') {
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
    }
}