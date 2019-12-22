
<%@page isELIgnored="false"%>
<body bgcolor="olive">

<h1>ADD License Details</h1>
<form action="controller" method="post">
  License type : <input type="text" name="type"><br>
  <input type="hidden" name="pid" value="${pid}"/>
  <input type="submit" value="addLicense" name="param">  
</form>
</body>