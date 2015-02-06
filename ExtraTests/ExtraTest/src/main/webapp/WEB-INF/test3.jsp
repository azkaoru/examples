<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
<html:form action="/test3-input">
    <c:forEach var="i" begin="1" end="2" step="1">
        <html:text property='value(input_${i})'/><p>
    </c:forEach>
    <html:submit/>
</html:form>

</body>
</html>