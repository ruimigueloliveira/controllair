pipeline {
	agent any

	stages {

		// stage('Cloning Repository') {
        //     steps {
        //         git(
        //             branch: 'master',
        //             url: 'https://github.com/DubaiDash-ES/code.git'
        //         )
        //         sh "chmod +x -R ${env.WORKSPACE}"
        //     }
        // }

		stage ('Compile Stage') {
			steps {
				sh 'mvn --version'
                sh 'java -version'
                sh 'docker --version'

				sh 'mvn clean install'

			}
		}

		// stage ('Deploy') {
        //     steps{
        //         sh 'mvn deploy -f pom.xml -s settings.xml' 
        //     }
        // }


		
	}
}
