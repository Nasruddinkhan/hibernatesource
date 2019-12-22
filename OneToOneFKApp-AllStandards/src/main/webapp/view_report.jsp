<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body bgcolor="cyan">
<h1>Person With License Details</h1>
<c:choose>
  <c:when test="${listLicDTO ne null }">
   <table border="1">
    <tr><th>pid</th><th>firstname</th><th>lastname</th><th>age</th><th>lid</th><th>type</th><th>valid From</th><th>valid To</th></tr>
    <c:forEach var="lic" items="${listLicDTO }">
      <tr>
       <td>${lic.licenseHolder.pid}</td>
       <td>${lic.licenseHolder.firstName}</td>
       <td>${lic.licenseHolder.lastName}</td>
       <td>${lic.licenseHolder.age}</td>
       <td>${lic.lid }</td>
       <td>${lic.type }</td>
       <td>${lic.validFrom }</td>
       <td>${lic.validTo}</td>
      </tr>
    </c:forEach>
   </table>
  </c:when>
 </c:choose>
 <hr>
 <h1>Person Details WithOut License </h1>
 <c:choose>
  <c:when test="${listPersonDTO ne null }">
   <table border="1">
    <tr><th>pid</th><th>firstName</th><th>lastName</th><th>age</th><th>Click to get License</th></tr>
     <c:forEach var="person" items="${listPersonDTO}">
      <tr>
       <td>${person.pid}</td>
       <td>${person.firstName}</td>
       <td>${person.lastName}</td>
       <td>${person.age}</td>
       <td><a href="controller?param=link2&pid=${person.pid}">Add License</a> </td>
      </tr>
     </c:forEach>
   </table>
    <p style="color:red">${licenseMsg}</p>
  </c:when>
  </c:choose>
 </body>