#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                 bat 'mvn clean package'
            }
               }
   }
}