#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Maven Install') {
            agent {
               dockerfile true
                   }
            steps {
                 bat 'mvn clean install'
            }
        }
        stage('Docker Build') {
            agent any
            steps {
                bat 'docker build -t s'
                }
               }
   }
}