pipeline {
    agent any
    environment {
        PROJECT_DIR = "/var/jenkins_home/app-team16"    
    }
    stages {
        stage('Build and tag backend image') {
            steps {
                echo 'Building backend image...'
                sh 'docker build -f ${PROJECT_DIR}/devops/prod/docker/backend/Dockerfile -t team16-backend ${PROJECT_DIR}'
                echo 'Taging backend image...'
                sh 'docker tag team16-backend localhost:5000/team16-backend'
            }
        }
        stage('Build and tag frontend (nginx) image') {
            steps {
                echo 'Building frontend (nginx) image...'
                sh 'docker build -f ${PROJECT_DIR}/devops/prod/docker/nginx/Dockerfile -t team16-nginx ${PROJECT_DIR}'
                echo 'Taging frontend (nginx) image...'
                sh 'docker tag team16-nginx localhost:5000/team16-nginx'
            }
        }
        stage("Push all images to local registry") {
            steps {
                echo 'Pushing backend image to registry...'
                sh 'docker push localhost:5000/team16-backend'
                echo 'Pushing frontend (nginx) image to registry...'
                sh 'docker push localhost:5000/team16-nginx'
            }
        }
    }
}
