<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
    <body>
        <html:form action="/test4-dispatch">
            <html:text property="message"/>
            <html:submit property="execute"><bean:message key="submit.dispatch1"/></html:submit>
            <html:submit property="execute"><bean:message key="submit.dispatch2"/></html:submit>
        </html:form>
    </body>
</html>