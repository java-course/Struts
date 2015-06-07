<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Struts Example Page</title>
        </head>
    </head>
    <body>

    Users list

    <ul>
    <c:forEach items="${users}" var="p">
        <li><a href="/user.do?id=${p.id}">${p.name}</a></li>
    </c:forEach>
    </ul>


    Add new User

    <html:errors/>
    <html:form action="/add">
        <table>
            <tr>
                <td>id:</td>
                <td><html:text name="lookupForm" property="id"/></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><html:text name="lookupForm" property="name"/></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><html:text name="lookupForm" property="email"/></td>
            </tr>
            <tr>
                <td>age:</td>
                <td><html:select name="lookupForm" property="age">
                    <c:forEach begin="10" end="100" var="i">
                        <html:option value="${i}"/>
                    </c:forEach>
                </html:select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><html:submit/></td>
            </tr>
        </table>
    </html:form>


    </body>
</html>