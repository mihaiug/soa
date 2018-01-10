<html>
<head>
  <title>InfoValutar Web Service Client</title>
</head>
<body>
<?php

$moneda = isset($_REQUEST['moneda']) ? $_REQUEST['moneda'] : "";

echo "<h2>BNR - Exchange rates</h2>";
echo "<form action='index.php' method='GET'>";
echo "Currency: <input name='moneda' value='$moneda'/> e.g. EUR, USD, GBP<br/>";
echo "<input type='submit' name='submit' value='Submit'/>";
echo "</form>";

if($moneda != ''){
  $client = new SoapClient('http://www.infovalutar.ro/curs.asmx?wsdl',
              array( 'exceptions' => 1,'trace' => TRUE));
  try {
    
    $result = $client-> GetLatestValue(array('Moneda' => $moneda));
    
    echo "The exchange rate for 1 $moneda is " . $result->GetLatestValueResult ." RON <br/>";
    echo  "<hr/>";
    echo "<h3>REQUEST:</h3>" ; 
    echo "<textarea rows='10' cols='100'>";
    echo  htmlentities(str_ireplace('><', ">\n<", $client->__getLastRequest()));
    echo "</textarea>";
    echo "<h3>RESPONSE:</h3>";
    echo "<textarea rows='10' cols='100'>";
    echo htmlentities(str_ireplace('><', ">\n<", $client->__getLastResponse()));
    echo "</textarea>";  
  } catch (SoapFault $e) {
    echo "Error:" . $e->faultstring; 
  }  
}
?>
</body>
</html>
