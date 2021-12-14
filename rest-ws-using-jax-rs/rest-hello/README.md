`Hello World` Simple REST Web Service Server and Client
=======================================================

Summary
------------
This example shows how to build and deploy a simple web service [server](rest-hello-ws-service) and [client](rest-hello-ws-client) with Jersey - Java API for RESTful Web Services (JAX-RS).
 

Requirements
------------
In order to compile and run examples the following software are needed:

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Apache Maven](https://maven.apache.org) 
* [Apache Tomcat](https://tomcat.apache.org)
* [Spring Tool Suite](https://spring.io/tools)
* [SoapUI](https://www.soapui.org)


Compile and run application
----------------------------
After you download the project in order to compile project and run the application the following operations must be performed:  

### Run Server ###

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import ->  Import Existing Maven Projects`
  - Select the folder where is located the `rest-hello-ws-service` project (e.g. `d:\workspace\rest-hello\rest-hello-ws-service`)
* Run the project:
  - From the `Package Explorer` view select the `rest-hello-ws-service` project, right click and select `Run As -> Run on Server`
  - For testing, you can access this URL:  [http://localhost:8080/rest-hello](http://localhost:8080/rest-hello).

Alternatively, if you use Apache Maven the following commands must executed:
``` bat
cd /d  d:\workspace\rest-hello\rest-hello-ws-service
mvn clean package
mvn jetty:run
```

### Run Client ###

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import ->  Import Existing Maven Projects`
  - Select the folder where is located the `rest-hello-ws-client` project (e.g. `d:\workspace\rest-hello\rest-hello-ws-client`)

* Run the project:

    - From the `Package Explorer` view select `ro.ucv.inf.soa.ws.rest.HelloRestClient` class, right click and select `Run As -> Java Application`
    
 Alternatively, if you use Apache Maven the following commands must executed:
``` bat
cd /d  d:\workspace\rest-hello\rest-hello-ws-client
mvn clean package
mvn exec:java
```   
