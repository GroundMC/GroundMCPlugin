pipeline {
  agent any
  tools {
        maven 'Maven3'
        jdk 'Java9'
  }
  stages {
    stage('Clean') {
      steps {
        sh 'mvn clean'
      }
    }
    stage('Parallel Compile') {
      parallel {
         stage('Compile Java8') {
           tools {
             maven 'Maven3'
             jdk 'Java8'
           }
           steps {
             sh 'mvn compile'
           }
         }
         stage('Compile Java9') {
           tools {
             maven 'Maven3'
             jdk 'Java9'
           }
           steps {
             sh 'mvn compile'
           }
         }
      }
    }
    stage('Parallel Test') {
      parallel {
        stage('Test Java8') {
          tools {
            maven 'Maven3'
            jdk 'Java8'
          }
          steps {
            sh 'mvn test'
          }
          post {
            success {
              junit 'target/surefire-reports/**/*.xml'
            }
          }
        }
        stage('Test Java9') {
          tools {
            maven 'Maven3'
            jdk 'Java9'
          }
          steps {
            sh 'mvn test'
          }
          post {
            success {
              junit 'target/surefire-reports/**/*.xml'
            }
          }
        }
      }
    }
    stage('Package') {
      steps {
        sh 'mvn package'
      }
    }
    stage('Archive') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', excludes: 'target/original*'
      }
    }
  }
}
