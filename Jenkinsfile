pipeline {
  agent any
  tools {
        maven 'Maven3'
        jdk 'Java10'
  }
  stages {
    stage('Clean') {
      steps {
        sh 'mvn clean'
      }
    }
    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Package') {
      steps {
        sh 'mvn package'
      }
    }
    post {
      always {
        archiveArtifacts artifacts: 'target/*.jar', excludes: 'target/original*', fingerprint: true
        junit 'target/surefire-reports/*.xml'
      }
    }
  }
}
