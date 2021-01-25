pipeline{

    agent any
    
    stages{
    
         stage("build"){
               steps{
                  echo "building the application"
                  bat "mvn -f testexamples/pom.xml clean install"
               }
         }
         stage("test"){
               steps{
                  echo "testing the application"
               }
         }
    }
}
         
