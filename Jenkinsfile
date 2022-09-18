pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/malllove/CalculatorApp.git'
                
                sh "./run_build.sh"
                sh "./run_tests.sh"
                sh "mvn clean package"
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.jar'
                    emailext body: 'Build success', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Jenkins Build'
                }
            }
        }
        stage('Deployment') {
            steps {
                sh "cp target/*.jar /var/lib/jenkins/ArtifactsDir"
            }
        }
    }
}
