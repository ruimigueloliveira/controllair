pipeline {
	agent any

	stages {

		stage ('Compile Stage') {
			steps {
				sh 'mvn --version'
                sh 'java -version'
                sh 'docker --version'

				sh 'mvn clean install'

			}
		}

		stage ('Deploy') {
            steps{
                sh 'mvn deploy -f pom.xml -s settings.xml' 
            }
        }


		
	}
}
