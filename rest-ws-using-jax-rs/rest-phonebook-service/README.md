PhoneBook REST Web Service
==========================

Introduction
------------
This example demonstrates how to develop RESTful web service that manage a _Phone Book_ using Java API for RESTful Web Services (JAX-RS).

Requirements
------------
In order to compile, run and test this application the following software are needed:

* [JDK 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html)
* [Apache Maven](https://maven.apache.org) 
* [Apache Tomcat](https://tomcat.apache.org)
* [Spring Tool Suite](https://spring.io/tools)
* [Postman - Chrome Addon](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop)


Web Service Methods
-------------------
The methods implemented by the service are presented in the following table:

Method |URI path                                        | Description                        | Expected Results
-------|----------------------------------------------- | ---------------------------------- | --------------------------------------------
GET    |`_/rest-phonebook/api/contacts_`       | Gets list of all contacts          | List of contacts as JSON or XML
GET    |`_/rest-phonebook/api/contacts/{id}_`| Gets contact with specified `id`  | Contact as JSON or XML
POST   |`_/rest-phonebook/api/contacts_`      | Add a contact to phonebook          | Redirect to location where gets added contact
PUT    |`_/rest-phonebook/api/contacts/{id}_`| Update contact with specified `id` | Nothing
DELETE |`_/rest-phonebook/api/contacts/{id}_`| Delete contact with specified `id` | Nothing


### API Methods Invoking

####Add a contact####
______________________

```json
POST /rest-phonebook/api/contacts
Content-Type: application/json

{
"name" : "Mihai",
"phone" : "07000000"
}

RESPONSE: HTTP 201 (Created)
Location header:http://localhost:8080/rest-phonebook/api/contacts/1
```

OR

```xml
POST /rest-phonebook/api/contacts
Content-Type: application/xml

<contact>
    <name>Mihai</name>
    <phone>07200000</phone>
</contact>

RESPONSE: 
HTTP 201 (Created)
Location header:http://localhost:8080/rest-phonebook/api/contacts/1
```

###Get all contacts###
______________________

```json
GET /rest-phonebook/api/contacts
Accept: application/json

RESPONSE: 
200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "name": "Mihai",
        "phone": "07200000"
    },
    {
        "id": 2,
        "name": "Santa Claus",
        "phone": "072222222"
    }    
]
```

```xml
GET /rest-phonebook/api/contacts
Content-Type: application/xml

RESPONSE
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<contacts>
    <contact>
        <id>1</id>
        <name>Misu</name>
        <phone>07200000</phone>
    </contact>
    <contact>
        <id>2</id>
        <name>Santa Claus</name>
        <phone>072222222</phone>
    </contact>
</contacts>
```

###Get a contact###
______________________

```json
GET /rest-phonebook/api/contacts/1
Accept: application/json

RESPONSE: 
200 OK
Content-Type: application/json

 {
    "id": 1,
    "name": "Mihai",
    "phone": "07200000"
}
```

```xml
GET /rest-phonebook/api/contacts/1
Content-Type: application/xml

RESPONSE
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<contact>
    <id>1</id>
    <name>Misu</name>
    <phone>07200000</phone>
</contact>
```

###Update a contact###
______________________

```json
POST /rest-phonebook/api/contacts/1
Content-Type: application/json

{
"name" : "Mihai Gabroveanu",
"phone" : "07000000"
}
```

OR

```xml
POST /rest-phonebook/api/contacts/1
Content-Type: application/xml

<contact>
    <name>Mihai Gabroveanu</name>
    <phone>07200000</phone>
</contact>
```

###Delete a contact###
______________________

```json
DELETE /rest-phonebook/api/contacts/1

```

Compile and run application
----------------------------
After you download the project in order to compile project and run the application the following operations must be performed:  

### Using Maven
To compile project using the Apache Maven execute:
``` bat
cd /d  d:\workspace\rest-phonebook-service
mvn clean package
```
This command produce the `rest-phonebook.war` archive that can be deployed in any servlet container like Tomcat, Jetty, etc.  

For example, to deploy this application into Tomcat Server just copy the `rest-phonebook.war` in `tomcat-install-directory\webapps` and start the server using following command:

``` bat
cd /d tomcat-install-directory\bin
start.bat
```

Alternatively, you can run the application using Maven Jetty plugin:

``` bat
cd /d  d:\workspace\rest-phonebook-service
mvn jetty:run
```
This command launches _Maven Embeded Jetty_ web server and next, use any REST Client (e.g. Postman) to access your resources under the following URL: [http://localhost:8080/rest-phonebook/] (http://localhost:8000/rest-phonebook/)


### Using Spring Tool Suite

To compile and run the project using STS you must perform the following steps:

* Import the project:
 - `File -> Import -> Import Existing Maven Projects`
 -  Select the folder where is located the `rest-phonebook-service` project (e.g. `d:\workspace\rest-phonebook-service`)
* Run the project:
 - From the `Package Explorer` view select the  `rest-phonebook-service` project, right click and select `Run As -> Run on Server`
