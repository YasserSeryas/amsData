pipeline {
  
          agent any

          tools {
            maven 'maven'
          }

          stages{
            stage('Get from git project'){
  steps {
    git 'https://github.com/YasserSeryas/amsData.git'
  }
            }

           // Create a new .jar file 

            stage('Create a new .jar') {

                steps {
                    
                   sh 'mvn clean install -DskipTests'
                
                      }

          
            }
}
}
