<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authorisation</title>

</head>
<body>
<div style="text-align: center;">

    <form method="POST" action="auth" name="user_authorise_form">

        <div>
            <label>
                <input name="login" type="text"
                       value="<c:out value="${login}"/>"
                />
            </label>
            <label>
                <input name="password" type="text"
                       value="<c:out value="${password}"/>"
                />
            </label>
        </div>

        <div>
            <label>
                <input type="submit" value="Submit"/>
            </label>
        </div>
    </form>

</div>
</body>
</html>