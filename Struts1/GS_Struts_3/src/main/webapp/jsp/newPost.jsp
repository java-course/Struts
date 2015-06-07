<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<body>

<jsp:include page="header.jsp"/>


<html:form action="/addPost.do">


    <c:choose>
        <c:when test="${post ne null}">
            <c:set var="isEdit" value="true"/>
            <h1>Edit blog post ${post.title}</h1>
        </c:when>
        <c:otherwise>
            <h1>Create new blog post</h1>
        </c:otherwise>
    </c:choose>


    <table>

        <c:if test="${isEdit}">
            <html:hidden name="postForm" property="id" value="${post.id}"/>
        </c:if>

        <tr>
            <td>Title</td>
            <td><html:text name="postForm" property="title" value="${post.title}"/></td>
        </tr>
        <tr>
            <td>Summary</td>
            <td><html:textarea name="postForm" property="summary" value="${post.summary}"/>
            </td>
        </tr>
        <tr>
            <td>Body</td>
            <td>
                <html:textarea name="postForm" property="body" value="${post.body}"/>
            </td>
        </tr>
        <tr>
            <td>Category</td>
            <td>

                <select name="category">
                    <c:forEach items="${categories}" var="cat">
                        <option
                                <c:if test="${isEdit && cat.id == post.id}">selected="selected"</c:if>
                                value="${cat.id}">${cat.name}</option>
                    </c:forEach>

                </select>


            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>


</html:form>


</body>
</html>
