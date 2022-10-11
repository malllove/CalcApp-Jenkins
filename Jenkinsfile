pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {  
                sh "./run_build.sh"
            }
        }
        stage('Test') {
            steps {                
                sh "./run_tests.sh"
            }
        }
        stage('Package') {
            steps {                
                sh "mvn clean package"
                sh '''
                cd target/
                mv original*.jar original-CalculatorApp-build-number-${BUILD_NUMBER}.jar
                mv CalculatorApp*.jar CalculatorApp-build-number-${BUILD_NUMBER}.jar
                '''
                archiveArtifacts artifacts: '**/target/*.jar'
            }
        }
        stage('Deployment') {
            steps {
                sh "cp target/*.jar /var/lib/jenkins/ArtifactsDir"
            }
        }
    }
    post {
         success {
             emailext body: 'Build success', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Jenkins Build Number-${BUILD_NUMBER}'
            }
                
         failure {
             emailext body: 'Build failed!!!', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Jenkins Build Nubmer-${BUILD_NUMBER}'
           }
    }
}
