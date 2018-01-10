Calculator SOAP Web Service and Client
======================================

Summary
------------
This example shows how to build and deploy a simple web service and client with JAX-WS Java API for XML Web Services (JAX-WS).


Requirements
------------
In order to compile and run examples the following software are needed:

* [JDK 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html)
* [Spring Tool Suite](https://spring.io/tools)
* [SoapUI](https://www.soapui.org)


Compile and run application
----------------------------
After you download the project in order to compile project and run the application the following operations must be performed:  

### Web Service Server ###

To compile and run the project using STS you must perform the following steps:

* Import the project:

  - `File -> Import ->  Existing Projects into Workspace`
  - Select the folder where is located the `server` project (e.g. `d:\workspace\jax-ws-calculator\server`)
* Run the project:
 
  - From the `Package Explorer` view select the  `jax-ws-calculator-server` project, right click and select `Run As -> Java Application`
  - For testing, you can access this URL : [http://localhost:9090/calculator?wsdl](http://localhost:9090/calculator?wsdl), if you see the WSDL, it means web services are deploy successfully.


### Web Service Client ###

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import ->  Existing Projects into Workspace`
  - Select the folder where is located the `client` project (e.g. `d:\workspace\jax-ws-calculator\client`)

* Run the project:
  - From the `Package Explorer` view select the  `jax-ws-calculator-client` project, right click and select `Run As -> Java Application`
