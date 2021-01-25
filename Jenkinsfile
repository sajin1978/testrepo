pipeline{

    agent any
    
    stages{
    
         stage("build"){
               steps{
                  echo "building the application"
                  bat "mvn clean install"
               }
         }
         stage("test"){
               steps{
                  echo "testing the application"
               }
         }
    }
}
         
