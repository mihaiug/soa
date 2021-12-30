PhoneBook REST Web Service using Java Spring Framework
======================================================

Introduction
------------
This example demonstrates how to develop RESTful web service that manage a _Phone Book_ using Java Spring Framework.

The phonebook contacts will be stored in a MySQL database. A _contact_ is characterized by the following attributes:

* `id` - the contact id
* `name` - the contact name
* `phone` - the contact phone

For database CRUD operations is used JPA from Spring Framework.

Requirements
------------
In order to compile, run and test this application the following software are needed:

* [JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)
* [MySQL](https://dev.mysql.com/downloads/mysql/)
* [Apache Maven](https://maven.apache.org) 
* [Apache Tomcat](https://tomcat.apache.org)
* [Spring Tool Suite](https://spring.io/tools)
* [Postman - Chrome Addon](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop)


Web Service Methods
-------------------
The methods implemented by the REST Web service are presented in the following table:

Method  |URI path                                        | Description                        | Expected Results
--------|----------------------------------------------- | ---------------------------------- | --------------------------------------------
`GET`   |_`/rest-phonebook/api/contacts`_       | Gets list of all contacts          | List of contacts as JSON or XML
`GET`   |_`/rest-phonebook/api/contacts/{id}`_| Gets contact with specified `id`  | Contact as JSON or XML
`POST`  |_`/rest-phonebook/api/contacts`_      | Add a contact to phonebook          | Redirect to location where gets added contact
`PUT`   |_`/rest-phonebook/api/contacts/{id}`_| Update contact with specified `id` | Nothing
`DELETE`|_`/rest-phonebook/api/contacts/{id}`_| Delete contact with specified `id` | Nothing


### API Methods Invoking

#### Add a contact
______________________
##### JSON Syntax
```json
POST /rest-phonebook/api/contacts
Content-Type: application/json
Accept: application/json
{
"name" : "Mihai",
"phone" : "07200000"
}

RESPONSE: HTTP 201 (Created)
Location header:http://localhost:8080/rest-phonebook/api/contacts/1
{
"id": 1,
"name" : "Mihai",
"phone" : "07200000"
}
```

##### XML Syntax

```xml
POST /rest-phonebook/api/contacts
Content-Type: application/xml
Accept: application/xml
<contact>
    <name>Mihai</name>
    <phone>07200000</phone>
</contact>

RESPONSE: 
HTTP 201 (Created)
Location header: http://localhost:8080/rest-phonebook/api/contacts/1
<contact>
    <id>1</id>
    <name>Mihai</name>
    <phone>07200000</phone>
</contact>
```

#### Get all contacts
______________________
##### JSON Syntax

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
##### XML Syntax
```xml
GET /rest-phonebook/api/contacts
Accept: application/xml

RESPONSE: 
200 OK
Content-Type: application/xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<List>
    <item>
        <id>1</id>
        <name>Mihai</name>
        <phone>07200000</phone>
    </item>
    <item>
        <id>2</id>
        <name>Santa Claus</name>
        <phone>072222222</phone>
    </item>
</List>
```

#### Get a contact
______________________

##### JSON Syntax

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
##### XML Syntax
```xml
GET /rest-phonebook/api/contacts/1
Accept: application/xml

RESPONSE: 
200 OK
Content-Type: application/xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<contact>
    <id>1</id>
    <name>Mihai</name>
    <phone>07200000</phone>
</contact>
```

#### Update a contact
______________________

##### JSON Syntax

```json
PUT /rest-phonebook/api/contacts/1
Content-Type: application/json
Accept: application/json

{
"name" : "Mihai Gabroveanu",
"phone" : "07000000"
}
```

##### XML Syntax

```xml
PUT /rest-phonebook/api/contacts/1
Content-Type: application/xml
Accept: application/xml
<contact>
    <name>Mihai Gabroveanu</name>
    <phone>07200000</phone>
</contact>
```

#### Delete a contact
______________________

```json
DELETE /rest-phonebook/api/contacts/1
RESPONSE: 
200 OK
```

Compile and run application
----------------------------

In order to run this application you must create a MySQL database called `db_phonebook`:

```sql
CREATE DATABASE db_phonebook CHARACTER SET utf8 COLLATE utf8_bin;
```
Optionally, you can add a database user to connect to database. In our case we use default user `root` without password. 

The database connection details can be changed from file `src/main/resources/application.properties`:

```properties 
# Database connection details
spring.datasource.url=jdbc:mysql://localhost:3306/db_phonebook?autoReconnect=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=

# Hibernate properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```


After you download the project in order to compile project and run the application the following operations must be performed:  

### Using Maven
To compile project using the Apache Maven execute:
``` bat
cd /d  d:\workspace\spring-rest-phonebook
mvn clean package
```
This command produce the `target/spring-rest-phonebook-0.0.1-SNAPSHOT.jar` Java archive. In order to start the Embeded Tomcat Server use the following command:

``` bat
cd /d d:\workspace\spring-rest-phonebook
java -jar target/spring-rest-phonebook-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the application using Maven:

``` bat
cd /d  d:\workspace\spring-rest-phonebook
mvnw spring-boot:run
```

### Using Spring Tool Suite

To compile and run the project using STS you must perform the following steps:

* Import the project:
  - `File -> Import -> Import Existing Maven Projects`
  -  Select the folder where is located the `spring-rest-phonebook` project (e.g. `d:\workspace\spring-rest-phonebook`)
* Run the project:
  - From the `Package Explorer` view select the `spring-rest-phonebook` project, right click and select `Run As -> Spring Boot App`

 
Testing Rest API
================
After _Embeded Tomcat Server_ web server start, use any REST Client (e.g. Postman) to access your resources under the following URL: [http://localhost:8080/rest-phonebook/](http://localhost:8000/rest-phonebook/)
 