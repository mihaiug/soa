package ro.ucv.inf.soa.ws;

import javax.xml.ws.Endpoint;

public class HelloWorldPubliser {

  public static void main(String[] args) {
    String endPointURL = "http://localhost:8080/hello";
    System.out.println("Web service running: " + endPointURL);
    System.out.println("Use CTRL+C to stop.");
    Endpoint.publish(endPointURL, new HelloWorld());
  }

}
