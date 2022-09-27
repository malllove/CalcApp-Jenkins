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
                    sh '''
                    cd target/
                    ls
                    mv original*.jar original-CalculatorApp-build-number-${BUILD_NUMBER}.jar
                    mv CalculatorApp*.jar CalculatorApp-build-number-${BUILD_NUMBER}.jar
                    '''
                    archiveArtifacts artifacts: '**/target/*.jar'
                    emailext body: 'Build success', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Jenkins Build'
                }
                
                failure {
                    emailext body: 'Build failed!!!', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Jenkins Build'
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
