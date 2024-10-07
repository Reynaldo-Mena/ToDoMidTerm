#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Maven Build') {
            steps {
                 bat 'mvn clean install'
                 bat 'mvn test'
                  bat 'docker build -t rey/todolist .'
            }
        }
   }
}