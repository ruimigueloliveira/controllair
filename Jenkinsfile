
pipeline {
	agent any
	
	tools{
	    jdk 'jdk11'
	    maven 'maven36'
	}
	
	environment {
        controllair_image = ''
        react_image = ''
	}
    
	stages {
	    // stage('Cloning repository') {
        //     steps {
        //         git(
        //             branch: 'main',
        //             url: 'https://github.com/ruimigueloliveira/controllair.git'
                    
        //         )
        //         sh "chmod +x -R ${env.WORKSPACE}"
        //     }
        // }

		stage ('Build') {
			steps {
			    dir("controllair"){
				    sh 'mvn clean install'
			    }
			}
		}
		
		stage ('Testing') {
		    steps{
			    dir("controllair"){
				    sh 'mvn test'
			    }
		    }
		}
		
		stage ('Deploying Artifact') {
            steps{
                dir("controllair"){
				    sh 'mvn deploy -f pom.xml -s settings.xml' 
			    }
            }
        }
		
	    stage("Publish controllair_image to RegistryVM"){
            steps{
                script{
                    controllair_image = docker.build("esp10/controllair_image", "./controllair")
                    docker.withRegistry("http://192.168.160.48:5000") {
                        controllair_image.push();
                    }
                }
                sh "docker images"
            }
        }
        
        stage("Publish react_image to RegistryVM"){
            steps{
                script{
                    react_image = docker.build("esp10/react_image", "./react")
                    docker.withRegistry("http://192.168.160.48:5000") {
                        react_image.push();
                    }
                }
                sh "docker images"
            }
        }
        
        stage('Deploying controllAir in PlayGroundVM ') { 
            steps {
                 withCredentials([usernamePassword(credentialsId: 'esp10_vms', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    script {
                      remote.user = USERNAME
                      remote.password = PASSWORD
                      remote.allowAnyHosts = true
                        
                    }
                    sshCommand remote: remote, command: "docker stop esp10_controllair"
                    sshCommand remote: remote, command: "docker rm esp10_controllair"
                    sshCommand remote: remote, command: "docker rmi 192.168.160.48:5000/esp10/controllair_image"
                    sshCommand remote: remote, command: "docker pull 192.168.160.48:5000/esp10/controllair_image"
                    sshCommand remote: remote, command: "docker create -p 10001:8080 --name esp10_controllair 192.168.160.48:5000/esp10/controllair_image"
                    sshCommand remote: remote, command: "docker start esp10_controllair"
                  }
            }
        }
        
        stage('Deploying react in PlayGroundVM ') { 
            steps {
                 withCredentials([usernamePassword(credentialsId: 'esp10_vms', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    script {
                      remote.user = USERNAME
                      remote.password = PASSWORD
                      remote.allowAnyHosts = true
                        
                    }
                    sshCommand remote: remote, command: "docker stop esp10_react"
                    sshCommand remote: remote, command: "docker rm esp10_react"
                    sshCommand remote: remote, command: "docker rmi 192.168.160.48:5000/esp10/react_image"
                    sshCommand remote: remote, command: "docker pull 192.168.160.48:5000/esp10/react_image"
                    sshCommand remote: remote, command: "docker create -p 10002:3000 --name esp10_react 192.168.160.48:5000/esp10/react_image"
                    sshCommand remote: remote, command: "docker start esp10_react"
                  }
            }
        }
	}
}
