pipeline {
	agent any
	stages {
		stage ('Compile Stage') {
			
			steps {
				maven: 'maven36'
				sh mvn clean install
			}
		}
	}
}
