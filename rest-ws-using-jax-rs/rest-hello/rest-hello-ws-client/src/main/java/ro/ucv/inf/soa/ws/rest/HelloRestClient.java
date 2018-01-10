package ro.ucv.inf.soa.ws.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;



public class HelloRestClient {

  public static void main(String[] args) throws Exception {
    
      String serviceApiURL = "http://localhost:8080/rest-hello/api";
      Client client = ClientBuilder.newClient();
      WebTarget serviceApiTarget = client.target(serviceApiURL);
      WebTarget helloServiceTarget = serviceApiTarget.path("hello");
      
      String response1 = helloServiceTarget.request(MediaType.TEXT_PLAIN).get(String.class);
      System.out.println(response1);
      String response2 = helloServiceTarget.path("Mihai").request(MediaType.TEXT_PLAIN).get(String.class);
      System.out.println(response2);
      String response3 = helloServiceTarget.path("Mihai").request(MediaType.TEXT_XML).get(String.class);
      System.out.println(response3);
      MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
      formData.add("name", "Mihai");
      
      String response4 = helloServiceTarget.
          request(MediaType.TEXT_PLAIN).
          post(Entity.entity(formData,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
      System.out.println(response4);
  }
}
