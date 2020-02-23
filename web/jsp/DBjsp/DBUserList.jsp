<%@ page import="java.util.List" %>
<%@ page import="model.withDataBase.DBModel" %>
<%@ page import="entities.withDataBase.DBUser" %>
<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 2/20/20
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <link rel="stylesheet" href="styles/style.css">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <title>USERS LIST</title>
</head>
    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>MY APP WITH DB</h1>
        </div>
            <div class="w3-container w3-center w3-margin-bottom w3-padding">
                <div class="w3-card-4">
                    <div class="w3-container w3-light-blue">
                        <h2>User List</h2>
                    </div>
                        <ul>
                            <%
                                List<DBUser> usersList = (List<DBUser>)request.getAttribute("users");
                                if(usersList != null && !usersList.isEmpty()){
                                    out.println("<ul class=\"w3-ul\">");
                                    for (DBUser user : usersList){
                                        out.println("<li class=\"w3-hover-sand \">"+ user.getId()+" "+ user.getName() + "</li>");
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
        <div class="w3-container w3-center w3-grey w3-opacity  w3-padding">
            <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/SimpleWebApp/DBAdd'">ADD ELEMENT</button>
            <button class="btn w3-btn w3-hover-green w3-round-large open_fast">EDIT</button>
            <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/SimpleWebApp'">DELETE</button>
            <button class="btn w3-btn w3-hover-green w3-round-large open_fast">EDIT</button>
            <button class="w3-btn w3-round-large" onclick="location.href='/SimpleWebApp/DBIndex.html'">Back to main</button>
        </div>
        <script>
            $('.open_fast').click(function () {
                $('.popup_fast').css({'top': $(window).scrollTop()+100}).fadeIn();
                $('.bg_popup').fadeIn();

                $('.bg_popup').click(function () {
                    $('.popup_fast').fadeOut();
                    $('.bg_popup').fadeOut();
                });
            });
        </script>
        <div class="popup_fast w3-round-large">
            <h3>Edit form</h3>
            <div class="form">
                <form method="post">
                    <input type="text" name="editId" class="input_name w3-round-large" placeholder="Edit ID">
                    <button type="submit" class="btn w3-round-large w3-green">ENTER</button>
                </form>
            </div>
        </div>
        <div class="bg_popup"></div>
    </body>
</html>
