pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/swathiRajaPrasanth/Demo_Shop.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test -Dheadless=true'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    allowMissing         : false,
                    alwaysLinkToLastBuild: true,
                    keepAll              : true,
                    reportDir            : 'target',
                    reportFiles          : 'ExtentReport.html',
                    reportName           : 'Extent Report'
                ])
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build failed — check Console Output for details'
        }
    }
}