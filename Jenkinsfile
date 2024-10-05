#!/usr/bin/env groovy
pipeline {
    agent { dockerfile true }
    stages {
        stage('Build') {
            steps {
                 bat 'mvn clean package'
            }
               }
   }
}