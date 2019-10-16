_Calculator_ SOAP Web Service
=============================

Summary
-------
This example shows how can be implemented a Web Service using [PHP SOAP extension](http://php.net/manual/en/book.soap.php).

The _PHP SOAP extension_ can be used to write SOAP Servers and Clients. It supports subsets of [SOAP 1.1](http://www.w3.org/TR/soap11/), [SOAP 1.2](http://www.w3.org/TR/soap12/) and [WSDL 1.1](http://www.w3.org/TR/wsdl) specifications.


Implementing Calculator Web Service
----------------------------
In the following we describe how can be implemented a simple _Calculator_ web service that exposes two operations:

* `add` - compute sum of two numbers
* `subtract` - compute diference of two numbers

The Web Service will accessible through SOAP protocol over HTTP. 


### Building SOAP Server ###

The service that handle the SOAP requests is presented in the following `server.php` file: 
```php
<?php
class Calculator {
  public function add($a, $b) {
    return $a + $b;
  }
  public function subtract($a, $b) {
    return $a - $b;
  }
}

$server = new SoapServer(null, array(
  'uri' => 'urn://inf.ucv.ro/ws'
));
$server->setClass('Calculator');
$server->handle();
?> 
```

### Building SOAP Client ###
The file `client.php` contains the client code:

```php
<html>
<head>
    <title>Calculator Web Service Client</title>
</head>
<body>
<?php

$a = isset($_REQUEST['a']) ? $_REQUEST['a'] : "";
$b = isset($_REQUEST['b']) ? $_REQUEST['b'] : "";
$operation = isset($_REQUEST['operation']) ? $_REQUEST['operation'] : "add";

print "<h2>Calculator Web Service</h2>";
print "<form action='client.php' method='GET'/>";
print "a: <input name='a' value='$a'/><br/>";
print "b: <input name='b' value='$b'/><br/>";
print "<input type='submit' name='operation' value='add'/>";
print "<input type='submit' name='operation' value='subtract'/>";
print "</form>";

if ($a != '' && $b != '') {
  $client = new SoapClient(null, array(
    'location' => "http://localhost/calculator/server.php",
    'uri' => "urn://inf.ucv.ro/ws",
    'trace' => TRUE,
    'exceptions' => TRUE
  ));
  
  $params = array(
    new SoapParam(intval($a), "a"),
    new SoapParam(intval($b), "b")
  );
  echo "Call service: $operation($a, $b) ";
  try {
    $result = $client->__soapCall($operation, $params);
    
    print "Result: " . $result;
    
    echo "<hr/>";
    echo "<h3>REQUEST:</h3>";
    echo "<textarea rows='14' cols='100'>";
    echo htmlentities(str_ireplace('><', ">\n<", $client->__getLastRequest()));
    echo "</textarea>";
    echo "<h3>RESPONSE:</h3>";
    echo "<textarea rows='14' cols='100'>";
    echo htmlentities(str_ireplace('><', ">\n<", $client->__getLastResponse()));
    echo "</textarea>";
  }
  catch (SoapFault $e) {
    echo "Error:" . $e->faultstring;
  }
}
?>
</body>
</html>
```

Running Example
---------------
In this section is presented how to deploy the code in [XAMPP for Windows 7.2.0](https://sourceforge.net/projects/xampp/files/XAMPP%20Windows/7.2.0/xampp-win32-7.2.0-0-VC15.zip/download) which contains PHP 7.

First, we must enable _PHP SOAP extension_ because this is not enabled by default. Open `xampp\php\php.ini` file, locate the following line:

``` ini
;extension=soap
```
and remove semi-column `;`  

``` ini
extension=soap
```
Save file and restart the _Apache Web Server_.

Next, copy the `calculator` folder in `xampp\htdocs\calculator` 

Now, in the Web Browser open [http://localhost/calculator](http://localhost/calculator).



