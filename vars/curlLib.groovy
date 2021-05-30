
def call(){
  println "This is for various curl (webserices) calls"
}



def getid (){
  ID = sh (script: """ curl -k -s "https://official-joke-api.appspot.com/random_joke" | jq '.id' """, returnStdout: true).trim()
  return ID
}
