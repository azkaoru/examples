<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<body>
<h1>SpringMVC + MyBatis example 1</h1>

<c:forEach var="col" items="${data}">
id: ${col.id}<br>
name: ${col.name}<br>
address: ${col.address}<br>
</c:forEach>

</body>
</html>