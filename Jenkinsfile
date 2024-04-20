pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    sh 'echo stage test finished'
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