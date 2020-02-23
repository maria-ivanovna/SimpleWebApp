<%--
  Created by IntelliJ IDEA.
  User: vladimir
  Date: 2/23/20
  Time: 5:34 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <title>NOT FOUND</title>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>MY APP WITH DB</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-red">
            <h2>USER NOT FOUND</h2>
        </div>
    </div>
</div>
<div class="w3-container w3-center w3-grey w3-opacity  w3-padding">
    <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/SimpleWebApp/DBList'">USERS LIST</button>
    <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/SimpleWebApp/DBAdd'">ADD ELEMENT</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/SimpleWebApp/DBIndex.html'">Back to main</button>
</div>
</body>
</html>
