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