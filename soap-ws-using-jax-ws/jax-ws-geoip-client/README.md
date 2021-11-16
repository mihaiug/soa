Building SOAP Web Service Client starting a WSDL file
=====================================================

Summary
------------
This example shows how to build a simple web service client with JAX-WS Java API for XML Web Services (JAX-WS) starting a WSDL file.

Requirements
------------
In order to compile and run this application the following software are needed:

* [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)
* [Apache Maven](https://maven.apache.org) 
* [Spring Tool Suite](https://spring.io/tools)


Compile and run application
----------------------------
After you download the project in order to compile project and run the application the following operations must be performed:  

### Using Apache Maven ###

1) To compile project execute:

``` bat
cd /d d:\workspace\jax-ws-geoip-client
mvn clean package
```

2) To run the client execute:

``` bat
cd /d d:\workspace\jax-ws-geoip-client
mvn exec:java
```

### Using Spring Tool Suite ###

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import ->  Existing Projects into Workspace`
  - Select the folder where is located the `client` project (e.g. `d:\workspace\jax-ws-geoip-client`)
  - In order to generate Java sources needed to connects to web service from WSDL file in the `Package Explorer` view select the `jax-ws-geoip-client` project, right click on `pom.xml` and select `Run As -> Maven generate-sources`.  

* Run the project:
  - From the `Package Explorer` view select the `jax-ws-geoip-client` project, right click on `ro.ucv.inf.soa.ws.GeoIPClient` and select `Run As -> Java Application`
