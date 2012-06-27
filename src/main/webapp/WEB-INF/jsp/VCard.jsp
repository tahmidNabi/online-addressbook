<%--
  Created by IntelliJ IDEA.
  User: tahmid
  Date: 6/26/12
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
<div class="post">
    <div class="title">${vCard.name}'s Data<%--${game.gameName} khelechen ?--%>
    </div>
    <div class="entry">
        <form:form method="post" commandName="vCard" action="">
            <table>
                <tr class="spaceunder2">
                    <td width="50%">
                        <fmt:message key="addVCard.name"/> :

                    </td>
                    <td width="50%">
                            ${vCard.name}
                    </td>

                </tr>

                <tr class="spaceunder2">

                    <td>
                        <fmt:message key="addVCard.fullName"/> :
                    </td>
                    <td>
                            ${vCard.fullName}
                    </td>

                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.org"/> :
                    </td>
                    <td>
                        ${vCard.organization}
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.title"/> :
                    </td>
                    <td>
                        ${vCard.title}
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.photo"/> :
                    </td>
                    <td>
                        ${vCard.photo}
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.homeTelephone"/> :
                    </td>
                    <td>
                       ${vCard.homeTelephone}
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.officeTelephone"/> :
                    </td>
                    <td>
                        ${vCard.officeTelephone}
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.address"/> :
                    </td>
                    <td>
                        ${vCard.address}
                    </td>

                    <td>
                        <form:errors path="address" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.email"/> :
                    </td>
                    <td>
                        ${vCard.email}
                    </td>

                </tr>

            </table>

            <table>
                <tr>
                    <td width="50%">
                        <input type="submit" align="right" name="delete" value="<fmt:message key="vCard.delete"/>" class="nicebutton">
                    </td>
                    <td width="50%">
                        <input type="submit" align="right" name="update" value="<fmt:message key="vCard.update"/>" class="nicebutton">
                    </td>
                    <td width="50%">
                        <input type="submit" align="right" name="export" value="<fmt:message key="vCard.export"/>" class="nicebutton">
                    </td>
                </tr>
            </table>

        </form:form>
    </div>
</div>

</body>
</html>