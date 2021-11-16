`Hello World` SOAP Web Service Server and Client
================================================

Summary
------------
This example shows how to build and deploy a simple web service and client with JAX-WS Java API for XML Web Services (JAX-WS).


Requirements
------------
In order to compile and run this application the following software are needed:

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Apache Maven](https://maven.apache.org) 
* [Apache Tomcat](https://tomcat.apache.org)
* [Spring Tool Suite](https://spring.io/tools)
* [SoapUI](https://www.soapui.org)


Compile and run application
----------------------------
After you download the project in order to compile project and run the application the following operations must be performed.  

### Run Server ###

To compile and run the project using STS you must perform the following steps:

* Import the project:

  - `File -> Import ->  Existing Projects into Workspace`
  - Select the folder where is located the `server` project (e.g. `d:\workspace\jax-ws-hello\server`)
* Run the project:
 
  - From the `Package Explorer` view select the  `jax-ws-hello-server` project, right click and select `Run As -> Java Application`
  - For testing, you can access this URL : [http://localhost:8080/hello?wsdl](http://localhost:8080/hello?wsdl), if you see the WSDL, it means web services are deploy successfully.


### Run Client ###

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import ->  Existing Projects into Workspace`
  - Select the folder where is located the `client` project (e.g. `d:\workspace\jax-ws-hello\client`)

* Run the project:
  - From the `Package Explorer` view select the  `jax-ws-hello-client` project, right click and select `Run As -> Java Application`
