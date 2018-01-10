package ro.inf.ucv.soa.ws.rs.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "hello" path)
 */
@Path("hello")
public class HelloWorldService {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayHello() {
    return "Hello World";
  }

  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/{name}")
  public String sayHelloTextPlain(@PathParam("name") String name) {
    return "Hello " + name;
  }

  /**
   * Method handling HTTP GET requests. 
   * The returned object will be sent to the client as "text/plain" media type.
   *
   * @return String that will be returned as a text/plain response.
   */
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String sayHelloTextPlainForm(@FormParam("name") String name) {
    return "Hello " + name;
  }
  
  @GET
  @Produces(MediaType.TEXT_XML)
  @Path("/{name}")
  public String sayHelloXML(@PathParam("name") String name) {
    return "<?xml version=\"1.0\"?>\n" + "<hello>" + "Hello " + name + "</hello>";
  }

}
