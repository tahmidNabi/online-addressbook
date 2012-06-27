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
    <div class="title"><fmt:message key="addVCard.header"/><%--${game.gameName} khelechen ?--%>
    </div>
    <div class="entry">
        <form:form method="post" commandName="vCardCmd" action="">
            <table>
                <tr class="spaceunder2">
                    <td width="50%">
                        <fmt:message key="addVCard.name"/> :

                    </td>
                    <td width="50%">
                        <form:input path="name"/>
                    </td>
                    <td width="50%">
                        <form:errors path="name" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">

                    <td>
                        <fmt:message key="addVCard.fullName"/> :
                    </td>
                    <td>

                        <form:input path="fullName"/>
                    </td>
                    <td>
                        <form:errors path="fullName" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.org"/> :
                    </td>
                    <td>
                        <form:input path="organization"/>
                    </td>

                    <td>
                        <form:errors path="organization" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.title"/> :
                    </td>
                    <td>
                        <form:input path="title"/>
                    </td>

                    <td>
                        <form:errors path="title" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.photo"/> :
                    </td>
                    <td>
                        <form:input path="photo"/>
                    </td>

                    <td>
                        <form:errors path="photo" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.homeTelephone"/> :
                    </td>
                    <td>
                        <form:input path="homeTelephone"/>
                    </td>

                    <td>
                        <form:errors path="homeTelephone" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.officeTelephone"/> :
                    </td>
                    <td>
                        <form:input path="workTelephone"/>
                    </td>

                    <td>
                        <form:errors path="workTelephone" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="addVCard.address"/> :
                    </td>
                    <td>
                       <form:textarea path="address" cols="30" rows="2"/>
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
                        <form:input path="email"/>
                    </td>

                    <td>
                        <form:errors path="email" cssClass="error"/>
                    </td>
                </tr>

            </table>

            <table>
                <tr>
                    <td width="50%">
                        <input type="submit" align="right" value="<fmt:message key="vCard.create"/>" class="nicebutton">
                    </td>
                </tr>
            </table>

        </form:form>
    </div>
</div>

</body>
</html>