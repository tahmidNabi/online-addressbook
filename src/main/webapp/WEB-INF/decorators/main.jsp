<%--
  Created by IntelliJ IDEA.
  User: pritom
  Date: 5/30/12
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Online Address Book</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>





</head>
<body>
<div id="wrapper">
    <div id="logo">
        <h1><a href="#">Online Address Book </a></h1>


        <p><em> <%--<a href="http://www.freecsstemplates.org/">Free CSS Templates</a>--%></em></p>


    </div>
    <hr/>
    <!-- end #logo -->
    <div id="header">
        <div id="menu">
            <ul>
                <%--<li><a href="/gamerschoice/GamersChoice.htm">Suggestions</a></li>
                <li id="menuItem1"><a href="/gamerschoice/Games.htm">Games</a></li>
                <li><a href="/gamerschoice/AddNewReview.htm">Review Game</a></li>
                <li><a href="/gamerschoice/TrackedItems.htm">Tracked Items</a></li>--%>

            </ul>
        </div>
        <!-- end #menu -->
        <div id="search">

            <c:if test="${not empty User}">
                <label style="font-size:15px; color:#FFFFFF">
                    Hello, ${User.userName} <a href="/online-addressbook/Logout.html">Log out</a>
                </label>
            </c:if>
        </div>
        <!-- end #search -->
    </div>
    <!-- end #header -->
    <!-- end #header-wrapper -->
    <div id="page">
        <div id="page-bgtop">
            <div id="content">
                <div>


                    <decorator:body/>
                </div>
            </div>
            <!-- end #content -->
            <div id="sidebar">
                <ul>
                    <li>

                        <h2 style="background-color:#1b63d2;color:#dedef5;font-weight:bold;">Features</h2>

                        <ul>

                            <c:if test="${not empty User}">
                                <li><a href="/online-addressbook/AddNewVCard.html">Add a new entry</a></li>
                                <li><a href="/online-addressbook/Addressbook.html">Address Book</a></li>
                                <li><a href="/online-addressbook/Search.html">Search</a></li>
                                <li><a href="/online-addressbook/ImportVCard.html">Import</a></li>
                            </c:if>
                            <c:if test="${empty User}">
                                <li><a href="/online-addressbook/Login.html">Log In</a></li>
                                <li><a href="/online-addressbook/Register.html">Register</a></li>
                            </c:if>



                        </ul>
                    </li>
                </ul>


                <br>
                <br>





            </div>
            <!-- end #sidebar -->
            <div style="clear: both;">&nbsp;</div>
        </div>
    </div>
    <!-- end #page -->
    <div id="footer-bgcontent">
        <div id="footer">

            <p>Developed by <a href="http://www.facebook.com/tahmid.nabi">Tahmid</a>
        </div>
    </div>
    <!-- end #footer -->
</div>

<!-- LOAD JAVASCRIPT LATE - JUST BEFORE CLOSING THE BODY TAG.
That way the browser will have loaded the images and will
know the width of the images. No need to specify the width
in the CSS or inline. -->

<!-- jQuery library - Please load it from Google API's -->

</body>
</html>
