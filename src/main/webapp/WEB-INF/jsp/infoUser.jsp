<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<input type="hidden" name="edit_link" id="edit_url" value="editUser.html?id=${user.id}"/>
<table border="0" cellpadding="0" cellspacing="0" class="twoCells">
    <tr>
        <td class="tdTitle">Name</td><td>${user.name}</td>
    </tr>
    <tr>
        <td class="tdTitle">Age</td><td>${user.age}</td>
    </tr>
    <tr>
        <td class="tdTitle">Status</td><td>${user.active}</td>
    </tr>
    <tr>
        <td class="tdTitle">Books</td>
        <td>
            <ul>
                <c:forEach items="${user.books}" var="book">
                    <li>${bookList[book].title}</li>
                </c:forEach>
            </ul>
        </td>
    </tr>
</table>