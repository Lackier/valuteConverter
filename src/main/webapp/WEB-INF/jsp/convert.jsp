<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Money Converter</title>

    <style>
        table, th, td {
            border: 1px solid #2e2e2e;
            border-collapse: collapse;
        }
        table {
            position: center;
            margin: auto;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body>
<div style="text-align: center;">

    <form method="POST" action="convert" name="currency_convert_form">
        <div>
            <h1>Конвертировать</h1>
        </div>

        <div>
            <label>
                <select name="currencyNameFrom">
                    <c:forEach items="${currenciesFrom}" var="currencyNameFrom">
                        <option value="${currencyNameFrom}">${currencyNameFrom}</option>
                    </c:forEach>
                </select>
            </label>
            <label>
                <select name="currencyNameTo">
                    <c:forEach items="${currenciesTo}" var="currencyNameTo">
                        <option value="${currencyNameTo}">${currencyNameTo}</option>
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

    <div>
        <h1>История</h1>
    </div>

    <div style="text-align: left;">
        <table>
            <c:forEach items="${history}" var="record">
                <tr>
                    <td> ${record.currencyFromName} </td>
                    <td> ${record.currencyToName} </td>
                    <td> ${record.sum} </td>
                    <td> ${record.sumObtained} </td>
                    <td> ${record.date} </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>
</html>