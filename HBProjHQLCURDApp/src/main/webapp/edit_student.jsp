<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1><center> Edit Student Details</center></h1>

<form action="psc" method="post">
  number : <input type="text" name="sno" value="${studDetails.sno}" readonly/><br>
  name : <input type="text" name="sname" value="${studDetails.sname}" /><br>
  Addresss:<input type="text" name="address" value="${studDetails.address}" /><br>
   <input type="submit"  value="edit" name="param"/>
</form>

${edit_msg}
<a href="index.jsp">home</a>