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
	
	echo "<textarea rows='14' cols='100'>";
    echo htmlentities(str_ireplace('><', ">\n<", $client->__getLastResponse()));
    echo "</textarea>";
  }
}
?>
</body>
</html>