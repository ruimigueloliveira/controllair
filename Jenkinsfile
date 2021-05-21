pipeline {
	agent any

	tools { 
        maven 'Maven 3.6' 
        jdk 'jdk8' 
    }

	stages {
		stage ('Compile Stage') {
			
			steps {
				sh 'mvn clean install'
			}
		}
		
	}
}
