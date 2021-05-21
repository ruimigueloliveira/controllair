pipeline {
	agent any

	stages {
		stage ('Compile Stage') {
			tools { 
				maven 'Maven 3.6' 
				jdk 'jdk11' 
    		}
			steps {
				sh 'mvn clean install'
			}
		}
		
	}
}
