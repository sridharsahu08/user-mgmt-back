pipeline {
    agent {
            label 'user-management'
        }


    stages {
        stage("Build") {
            steps {
                echo "Building.."
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage("Test") {
            steps {
                    sh 'mvn test'
                 }
              post {
                     always {
                     junit 'target/surefire-reports/*.xml'
                    }
            }
        }
        stage("Deploy") {
            steps {
                echo "Deploying...."
            }
        }
    }
}