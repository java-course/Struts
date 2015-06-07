<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
    <head>
        <title>${post.title}</title>
    </head>
<body>

    <jsp:include page="header.jsp"/>

    <span style="font-size: 32px; color: #00008b"><bean:write name="postForm" property="title"/></span>
    <p><bean:write name="postForm" property="summary"/></p>
    <hr/>
    <p><bean:write name="postForm" property="body"/></p>



</body>
</html>
