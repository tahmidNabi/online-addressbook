<%--
  Created by IntelliJ IDEA.
  User: tahmid
  Date: 6/26/12
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
<div class="post">
    <div class="title">AddressBook</div>

    <div class="entry">
        <table class="playedGameTable">
            <tr>
                <th>
                    Name
                </th>
                <th>
                    Organization
                </th>
                <th>
                    Title
                </th>
                <th>
                    Office Phone
                </th>
                <th>
                    Address
                </th>

            </tr>
            <c:forEach items="${vCards}" var="vCard">
                <c:url value="/VCard.html" var="displayURL">
                    <c:param name="vCardId" value="${vCard.vCardId}"/>
                </c:url>
                <tr>
                    <td>
                        <a href="${displayURL}">${vCard.fullName}</a>
                    </td>

                    <td>
                            ${vCard.organization}
                    </td>
                    <td>
                            ${vCard.title}
                    </td>
                    <td>
                            ${vCard.officeTelephone}
                    </td>
                    <td>
                            ${vCard.address}
                    </td>
                </tr>
                <br>
            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>