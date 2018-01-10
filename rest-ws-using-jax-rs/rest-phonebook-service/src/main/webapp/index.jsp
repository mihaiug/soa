<html>
<head>
	<title>PhoneBook REST Web Service</title>
</head>
<body>
	<h2>PhoneBook REST Web Service implemented using Java API for RESTful Web Services (JAX-RS)</h2>
	Actions:
	<!-- 
	<ul>
		<li>GET - <a href="<%=request.getContextPath()%>/api/contacts"><%=request.getContextPath()%>/api/contacts</a> Get All Contacts </li>
		<li>GET - <a href="<%=request.getContextPath()%>/api/contacts/1"><%=request.getContextPath()%>/api/contacts/id</a>Get Contact with id</li>
	</ul>
	-->
	<p>This example demonstrates how to develop RESTful web service that manage a <em>Phone Book</em> using Java API for RESTful Web Services (JAX-RS).</p>
<table border="1" cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      <th>Method </th>
      <th>URI path </th>
      <th>Description </th>
      <th>Expected Results</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>GET </td>
      <td><strong><em>rest-phonebook/api/contacts</em></strong> </td>
      <td>Gets list of all contacts </td>
      <td>List of contacts as JSON or XML</td>
    </tr>
    <tr>
      <td>GET </td>
      <td><strong><em>rest-phonebook/api/contacts/{id}</em></strong></td>
      <td>Gets contact with specified <em>id</em> </td>
      <td>Contact as JSON or XML</td>
    </tr>
    <tr>
      <td>POST </td>
      <td><strong><em>rest-phonebook/api/contacts</em></strong> </td>
      <td>Add a contact to phonebook </td>
      <td>Redirect to location where gets added contact</td>
    </tr>
    <tr>
      <td>PUT </td>
      <td><strong><em>rest-phonebook/api/contacts/{id}</em></strong></td>
      <td>Update contact with specified <em>id</em> </td>
      <td>Nothing</td>
    </tr>
    <tr>
      <td>DELETE </td>
      <td><strong><em>rest-phonebook/api/contacts/{id}</em></strong></td>
      <td>Delete contact with specified <em>id</em> </td>
      <td>Nothing</td>
    </tr>
  </tbody>
</table>  
</body>
</html>
