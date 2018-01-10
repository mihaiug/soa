mkdir bin
wsimport -verbose -keep  -s src -d bin "http://localhost:8080/hello?wsdl"