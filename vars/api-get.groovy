
import groovy.json.JsonSlurper
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils

import java.net.http.HttpClient;
import org.apache.http.impl.client.HttpClients;


//"https://official-joke-api.appspot.com/random_joke"
def getjsonalldata (URL) {
    def statusdetails = "no"
    CloseableHttpClient httpClient = HttpClients.createDefault();

    try {
        HttpGet request = new HttpGet(URL);
        request.addHeader("content-type", "application/json");

        CloseableHttpResponse response = httpClient.execute(request);
        try {

            if (statusdetails == "yes") {
                System.out.println(response.getProtocolVersion())  // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());
            }


            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                println(result);

                def slurper = new groovy.json.JsonSlurper()
                def jsonObj =  slurper.parseText(result)
                println(jsonObj['id'])
                println(jsonObj['type'])



            }
        } finally {
            response.close();
        }
    } finally {
        httpClient.close();
    }
}

def postjsondata (URl){
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet request = new HttpGet(URL);



}

getjsonalldata ("https://official-joke-api.appspot.com/random_joke")



