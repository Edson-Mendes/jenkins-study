pipeline {
    agent any
    stages {
        stage('build project') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}