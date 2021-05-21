pipeline {
	agent any
	tools { 
        jdk 'jdk11	' 
    }

	stages {
		stage ('Compile Stage') {
			
			steps {
				sh 'mvn --version'
                sh 'java -version'
                sh 'docker --version'

				sh 'mvn clean install'
			}
		}
		
	}
}
