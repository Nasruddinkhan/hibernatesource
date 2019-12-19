<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<h1><cemypracticeeR> Employee Report</cemypracticeeR></h1>
<c:choose>
  <c:when test="${reportData ne null }">
     <table border="1">
       <tr>
         <th>EID</th>
         <th>FIRSTNAME</th>
         <th>LASTNAME</th>
         <th>EMAIL</th>
       </tr>
   <c:forEach var="emp" items="${reportData}">
     <tr>
        <td>${emp.eid}</td>
        <td>${emp.firstname}</td>
        <td>${emp.lastname}</td>
        <td>${emp.email}</td>
     </tr>
   </c:forEach>
 </table>
</c:when>
<c:otherwise>
  <h1>No Records Found</h1>
</c:otherwise>
</c:choose>

<br><br><br>
 <!-- dispaly page nos  -->
 <c:forEach var="i"  begin="1" end="${pageCtn}" step="1">
   <a href="mypracticecontroller?pageNo=${i}">[${i}]</a> &nbsp;&nbsp;&nbsp;
 </c:forEach>

