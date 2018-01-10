package ro.ucv.inf.soa.ws;

import java.net.URL;

import javax.xml.namespace.QName;

import ro.ucv.inf.soa.ws.service.Calculator;
import ro.ucv.inf.soa.ws.service.CalculatorService;

public class CalculatorClient {
	public static void main(String[] args) throws Exception {
	  
	  URL wsdlLocation = new URL("http://localhost:9090/calculator?wsdl");
    QName serviceName = new QName("http://service.ws.soa.inf.ucv.ro/", "Calculator");
    
		Calculator calculator = new Calculator(wsdlLocation, serviceName);
		CalculatorService service = calculator.getCalculatorServiceImplPort();
		
		int a = 10;
		int b = 5;
		int sumResult = service.sum(a, b);
		System.out.println("Sum = " + sumResult);
		int diferenceResult = service.diference(a, b);
		System.out.println("Diference = " + diferenceResult);
		
	}
}
