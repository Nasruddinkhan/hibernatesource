<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 
<c:choose>

  <c:when test="${listStuds ne null}">
    <table border="1">
     <tr><td>sno</td><td>sname</td><td>sadd</td></tr>
     <c:forEach var="st" items="${listStuds}">
      <tr>
        <td><c:out value="${st.sno}"/></td>
        <td><c:out value="${st.sname}"/></td>
        <td><c:out value="${st.address}"/></td>
        <td><a href="psc?param=link2&no=${st.sno}">edit</a>
      </tr>
     </c:forEach>
    </table>
  </c:when>

  <c:otherwise>
    Records not found
  </c:otherwise>
  
</c:choose>
