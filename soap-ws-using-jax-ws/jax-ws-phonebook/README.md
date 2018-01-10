PhoneBook SOAP Web Service server and Client
============================================

Summary
------------
This example demonstrates how to develop a SOAP Web Service that manage a _PhoneBook_ using JAX-WS Java API for XML Web Services (JAX-WS).

Requirements
------------
In order to compile and run this application the following software are needed:

* [JDK 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html)
* [Apache Maven](https://maven.apache.org) 
* [Apache Tomcat](https://tomcat.apache.org)
* [Spring Tool Suite](https://spring.io/tools)
* [SoapUI](https://www.soapui.org)


Compile and run application
----------------------------
After you download the project in order to compile project and run the application the following operations must be performed:  

### Web Service Server ###

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import ->  Import Existing Maven Projects`
  - Select the folder where is located the `jax-ws-phonebook-servlet` project (e.g. `d:\workspace\jax-ws-phonebook-servlet`)
* Run the project:
  - From the `Package Explorer` view select the  `rest-hello-ws-service` project, right click and select `Run As -> Run on Server`
    - For testing, you can access this URL : [http://localhost:8080/jax-ws-phonebook/contacts?wsdl](http://localhost:8080/jax-ws-phonebook/contacts?wsdl), if you see the WSDL, it means web services are deploy successfully.

Alternatively, if you use Apache Maven the following commands must executed:
``` bat
cd /d  d:\workspace\jax-ws-phonebook-servlet
mvn clean package
mvn jetty:run
```

### Run Client ###

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import ->  Import Existing Maven Projects`
  - Select the folder where is located the `jax-ws-phonebook-client` project (e.g. `d:\workspace\jax-ws-phonebook-client`)

* Run the project:

    - From the `Package Explorer` view select `ro.ucv.inf.soa.ws.phonebook.PhoneBookClient` class, right click and select `Run As -> Java Application`
    
 Alternatively, if you use Apache Maven the following commands must executed:
``` bat
cd /d  d:\workspace\jax-ws-phonebook-client
mvn clean package
mvn exec:java
```  