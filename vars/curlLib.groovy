
def call(){
  println "This is for various curl (webserices) calls"
}



def getid (){
  ID_PROJECT = sh (script: """ curl -k -s "https://official-joke-api.appspot.com/random_joke" | jq '.id' """, returnStdout: true).trim()
  retrurn ID_PROJECT
}
