pipeline {

    agent any

    node {
	 stage ('Build') {
	   git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
           withMaven {
             sh "mvn clean verify"
	   } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
	 }
    }

    tools {
        maven 'maven:3.6.3' 
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile" 
        }
    }

         stage('testing stage') {
             steps {
                bat "mvn test"
        }
    }

          stage('deployment stage') {
              steps {
                bat "mvn deploy"
        }
    }

  }

}
