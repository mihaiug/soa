package ro.ucv.inf.soa.ws;

import javax.xml.ws.Endpoint;

import ro.ucv.inf.soa.ws.service.CalculatorService;
import ro.ucv.inf.soa.ws.service.CalculatorServiceImpl;

public class CalculatorServicePublisher {

	public static void main(String[] args) {
	  String endPointURL = "http://localhost:9090/calculator";
		CalculatorService service = new CalculatorServiceImpl();
		System.out.println("Web Service started: " + endPointURL);
		System.out.println("Use CTRL+C to stop.");
		Endpoint.publish(endPointURL, service);
	}

}
