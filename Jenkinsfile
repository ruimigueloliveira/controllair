def remote = [:]
remote.host = "192.168.160.87"
remote.name = "runtime"

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
		
		stage ('Deploy') {
            steps{
                sh 'mvn deploy -f pom.xml -s settings.xml' 
            }
        }
		
	    stage("Build image"){
            steps{
                sh "docker images"
                script{
                    docker.withRegistry('http://192.168.160.48:5000') {
                        db = docker.build("esp10/controllair", "./")
                    }
                }
            }
        }
        
        stage("Publish image"){
            steps{
                sh "docker images"
                script{
                    docker.withRegistry('http://192.168.160.48:5000') {
                        db.push()
                    }
                }
            }
        }
        
        stage('PlayGround Deploy') { 
            steps {
                 withCredentials([usernamePassword(credentialsId: 'esp10_vms', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    
                    script {
                      remote.user = USERNAME
                      remote.password = PASSWORD
                      remote.allowAnyHosts = true
                        
                    }
                    
                    sshCommand remote: remote, command: "docker stop esp10-controllair"
                    sshCommand remote: remote, command: "docker rm esp10-controllair"
                    sshCommand remote: remote, command: "docker rmi 192.168.160.48:5000/esp10/controllair"
                    sshCommand remote: remote, command: "docker pull 192.168.160.48:5000/esp10/controllair"
                    sshCommand remote: remote, command: "docker create -p 10001:3000 --name esp21-controllair 192.168.160.48:5000/esp10/controllair"
                    sshCommand remote: remote, command: "docker start esp10-controllair"
                     
                  }
                  
                
            }
        }

		


		
	}
}
