<%--
  Created by IntelliJ IDEA.
  User: tahmid
  Date: 6/26/12
  Time: 7:04 PM
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
    <div class="title">

    </div>

    <div class="entry">
      <form:form method="post" commandName="importCmd" enctype="multipart/form-data">
            <table>

                <tr class="spaceunder2">
                    <td>
                        <label style="font-weight:bold"><fmt:message key="import.command"/>:</label>
                    </td>
                    <td>
                        <input type="file" name="file" />
                    </td>

                </tr>

                <tr class="spaceunder2">
                    <td>
                        <input type="submit" value="<fmt:message key="import.button"/>" class="nicebutton"/>
                    </td>
                </tr>
            </table>





        </form:form>
    </div>
</div>
</body>
</html>