#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Maven Install') {
            agent {
                docker{
                    image 'maven:3.5.0'
                    }
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