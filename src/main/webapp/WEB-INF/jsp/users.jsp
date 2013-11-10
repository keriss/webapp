<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<c:set var="users" value="${data.users}"/>
<c:set var="books" value="${data.books}"/>
<html>
    <head>
       <title>Users</title>
       <link rel="stylesheet" href="css/style.css">
       <link rel="stylesheet" href="css/font-awesome.min.css">
       <link rel="stylesheet" href="css/smoothness/jquery-ui-1.10.3.custom.min.css">
       <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
       <script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
    </head>
    <body>
        <div class="cntr">
            <h2>Users&#160;<a href="addUser.html" class="acticon addButton" title="Add New User"><i class="fa fa-plus-square"></i></a></h2>
            <table border="0" cellpadding="0" cellspacing="0" class="dottedCells">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Age</td>
                        <td>Status</td>
                        <td>Books count</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr class="userData" id="row_usr${user.id}">
                        <td><c:out value="${user.name}" escapeXml="true"/></td>
                        <td>${user.age}</td>
                        <td>${user.active ? "Active" : "Passive"}</td>
                        <td>${fn:length(user.books)}</td>
                        <td><a class="acticon infoButton" id="infoUser_${user.id}" title="Info about user"><i class="fa fa-info-circle"></i></a><a href="editUser.html?id=${user.id}" class="acticon editButton" id="editUser_${user.id}" title="Edit user"><i class="fa fa-pencil-square-o"></i></a><a class="acticon delButton" id="delUser_${user.id}" title="Delete user"><i class="fa fa-trash-o"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div id="dialog-message" title="Information about user">
            </div>
            <h2>Books</h2>
            <table border="0" cellpadding="0" cellspacing="0" class="books dottedCells">
                <thead>
                    <tr>
                        <td>Title</td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr class="bookData" id="row_book${book.id}">
                        <c:choose>
                            <c:when test="${book.isBusy}">
                                <td class="busyBook">
                            </c:when>
                            <c:otherwise>
                                <td>
                            </c:otherwise>
                        </c:choose>
                        <c:out value="${book.title}" escapeXml="true"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <script type="text/javascript" src="js/process.js"></script>
</html>