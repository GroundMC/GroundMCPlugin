pipeline {
  agent any
  tools {
        maven 'Maven3'
        jdk 'Java8'
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean test package'
      }
      post {
        success {
          junit 'target/surefire-reports/**/*.xml'
        }
      }
    }
    stage('Archive') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', excludes: 'target/original*'
      }
    }
  }
}
