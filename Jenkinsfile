#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Maven Build') {
            steps {
                 bat 'mvn clean install'
            }
        }
        stage('Docker Build & Push') {
            steps {
                bat 'docker build -t angry_ptolemy .'
                bat 'docker run angry_ptolemy'
               }
              }
   }
}