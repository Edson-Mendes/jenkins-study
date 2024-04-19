pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
                success {
                    echo "SUCESSO!!!!"
                }
                failure {
                    echo "Falha na execução de testes"
                }
            }
        }
    }
}