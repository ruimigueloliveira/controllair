pipeline {
	agent any
	tools { 
        maven 'Maven 3.3.9' 
        jdk 'jdk11	' 
    }

	stages {
		stage ('Compile Stage') {
			
			steps {
				sh 'mvn --version'
                sh 'java -version'
                sh 'docker --version'

				sh "mvn clean install"
			}
		}
		
	}
}
