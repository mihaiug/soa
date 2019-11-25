package ro.ucv.inf.soa.ws.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.WebParam;
import javax.jws.WebService;

import ro.ucv.inf.soa.ws.exception.CalculatorException;

@WebService(serviceName = "Calculator", endpointInterface = "ro.ucv.inf.soa.ws.service.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {

  public CalculatorServiceImpl() {
    System.out.println("Create CalculatorServiceImpl instance");
  }

  @Override
  public int sum(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
    return a + b;
  }

  @Override
  public int diference(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
    return a - b;
  }

  @Override
  public int div(@WebParam(name = "a") int a, @WebParam(name = "b") int b) throws CalculatorException {
    if (b != 0) {
      return a / b;
    } else {
      throw new CalculatorException("Division by 0");
    }
  }

  /**
   * Called by container before the implementing class is called the first time.
   */
  @PostConstruct
  public void init() {
    System.out.println("Call @PostConstruct service method");
  }

  /**
   * Called by container before the implementing class goes out of operation.
   */
  @PreDestroy
  public void teardown() {
    System.out.println("Call @PreDestroy service method");
  }

}
