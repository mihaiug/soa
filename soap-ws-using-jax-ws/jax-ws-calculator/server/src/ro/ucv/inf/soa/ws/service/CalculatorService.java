package ro.ucv.inf.soa.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ro.ucv.inf.soa.ws.exception.CalculatorException;

@WebService
public interface CalculatorService {
  @WebMethod
  public int sum(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

  @WebMethod
  public int diference(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

  @WebMethod
  public int div(@WebParam(name = "a") int a, @WebParam(name = "b") int b) throws CalculatorException;
}
