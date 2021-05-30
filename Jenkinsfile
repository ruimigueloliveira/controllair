pipeline {
	agent any

	stages {

		stage ('Build') {
			steps {
				sh 'mvn --version'
                sh 'java -version'
                sh 'docker --version'

				sh 'mvn clean install'

			}
		}

		stage('Test') {
            steps {
                    echo "Testing"
                    sh "mvn test"
                }
            }
        }

		stage ('Deploy') {
            steps{
                sh 'mvn deploy -f pom.xml -s settings.xml' 
            }
        }


		
	}
}
