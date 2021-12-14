package ro.ucv.inf.soa.ws.phonebook.rest;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ro.ucv.inf.soa.ws.phonebook.exception.RecordNotFoundException;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<RecordNotFoundException>{

  @Context
  private HttpHeaders headers;

  public Response toResponse(RecordNotFoundException ex){
    System.out.println("Handle error 404");
    return Response
        .status(Response.Status.NOT_FOUND.getStatusCode())
        .type(MediaType.TEXT_PLAIN) //.type( getAcceptType())
        .entity(ex.getMessage())
        .build();

  }

//  private String getAcceptType(){
//       List<MediaType> accepts = headers.getAcceptableMediaTypes();
//       if (accepts!=null && accepts.size() > 0) {
//           //choose one
//       }else {
//           //return a default one like Application/json
//       }
//  }
}