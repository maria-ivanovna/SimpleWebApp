<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 2/18/20
  Time: 2:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <title>USERS LIST</title>
</head>
    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>My App</h1>
        </div>
            <div class="w3-container w3-center w3-margin-bottom w3-padding">
                <div class="w3-card-4">
                    <div class="w3-container w3-light-blue">
                        <h2>User List</h2>
                    </div>
                        <ul>
                            <%
                                List<String> usersList = (List<String>) request.getAttribute("users");
                                if(usersList != null && !usersList.isEmpty()){
                                    out.println("<ul class=\"w3-ul\">");
                                    for (String str : usersList){
                                        out.println("<li class=\"w3-hover-sand\">" + str + "</li>");
                                    }out.println("</ui>");
                                }else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                                        +
                                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                                        "   <h5>There are no users yet!</h5>\n" +
                                        "</div>");
                            %>
                        </ul>
                </div>
            </div>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/SimpleWebApp'">Back to main</button>
        </div>
    </body>
</html>
