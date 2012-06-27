<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 6/7/12
  Time: 12:07 PM
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
    <div class="title"><fmt:message key="registration.title"/><%--${game.gameName} khelechen ?--%>
    </div>
    <div class="entry">
        <form:form method="post" commandName="registrationCmd" action="">
            <table>
                <tr class="spaceunder2">
                    <td width="50%">
                        <fmt:message key="registration.userName"/> :

                    </td>
                    <td width="50%">
                        <form:input path="userName"/>
                    </td>
                    <td width="50%">
                        <form:errors path="userName" cssClass="error"/>
                    </td>
                </tr>

                <tr class="spaceunder2">

                    <td>
                        <fmt:message key="registration.password"/> :
                    </td>
                    <td>

                        <form:password path="password"/>
                    </td>
                    <td>
                        <form:errors path="password" cssClass="error"/>
                    </td>
                </tr>
                <tr class="spaceunder2">
                    <td>
                        <fmt:message key="registration.confirmPassword"/> :
                    </td>
                    <td>
                        <form:password path="confirmPassword"/>
                    </td>

                    <td>
                        <form:errors path="confirmPassword" cssClass="error"/>
                    </td>
                </tr>


            </table>

            <table>
                <tr>
                    <td width="50%">
                        <input type="submit" align="right" value="<fmt:message key="registration.title"/>" class="nicebutton">
                    </td>
                </tr>
            </table>

        </form:form>
    </div>
</div>

</body>
</html>