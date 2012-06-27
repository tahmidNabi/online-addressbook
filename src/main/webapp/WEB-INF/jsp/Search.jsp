<%--
  Created by IntelliJ IDEA.
  User: tahmid
  Date: 6/26/12
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
 <div class="title">
        <fmt:message key="search.title"/><%--${game.gameName} khelechen ?--%>
        <br>
        <br>
    </div>

    <div class="entry">

        <form:form method="post" commandName="searchCmd" action="">
            <table>
                <tr class="spaceunder2">
                    <td>
                       <fmt:message key="search.name"/> :
                    </td>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <input type="submit" align="right" value="<fmt:message key="search.title"/>" class="nicebutton">
                    </td>
                </tr>
            </table>
        </form:form>



    </div>
</body>
</html>