<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profession Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>User : </td>
                <%--<td><bean:write name="lookupForm" property="name"/></td>--%>
                <%--<td><bean:write name="lookupForm" property="email"/></td>--%>
                <%--<td><bean:write name="lookupForm" property="age"/></td>--%>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.age}</td>
            </tr>
        </table>
    </body>
</html>