<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Money Converter</title>
</head>
<body>
<div style="text-align: center;">

    <form method="POST" action="convert" name="currency_convert_form">
        <div>
            <h1>Converter</h1>
        </div>

        <div>
            <label>
                <select name="currencyNameFrom">
                    <c:forEach items="${currenciesFrom}" var="currencyName">
                        <option value="${currencyName}">${currencyName}</option>
                    </c:forEach>
                </select>
            </label>
            <label>
                <select name="currencyNameTo">
                    <c:forEach items="${currenciesTo}" var="currencyName">
                        <option value="${currencyName}">${currencyName}</option>
                    </c:forEach>
                </select>
            </label>
        </div>

        <div>
            <label>
                <input name="sum" type="text"
                       value="<c:out value="${sum}"/>"
                />
            </label>
            <label>
                <input name="sumObtained" type="text"
                       value="<c:out value="${sumObtained}"/>"
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