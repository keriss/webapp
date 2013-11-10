<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>
            <c:choose>
                <c:when test="${empty user.id}">Add User</c:when>
                <c:otherwise>Edit User</c:otherwise>
            </c:choose>
        </title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
    </head>
    <body>
        <div class="cntr w300">
            <h2>Users&#160;data</h2>
            <form:form method="POST" commandName="user" cssClass="userForm" name="userDataForm">
                <form:hidden path="id"/>
                <table>
                    <tr>
                        <td class="tdTitle">Name</td>
                        <td><form:input path="name"/></td>
                        <td><form:errors path="name" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td class="tdTitle">Age</td>
                        <td><form:input path="age"/></td>
                        <td><form:errors path="age" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td class="tdTitle">Active</td>
                        <td colspan="2"><form:checkbox path="active"/></td>
                    </tr>
                    <tr>
                        <td class="tdTitle">Books</td>
                        <td colspan="2">
                            <form:select multiple="true" path="books" size="10">
                                <form:options items="${bookList}" itemValue="id" itemLabel="title"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" class="actions">
                            <a onclick="document.forms['userDataForm'].submit(); return false;"><i class="fa fa-floppy-o">&#160;Save</i></a>&#160;
                            <a onclick="history.back();"><i class="fa fa-times-circle-o">&#160;Cancel</i></a>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>