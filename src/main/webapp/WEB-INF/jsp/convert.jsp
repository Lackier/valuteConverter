<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Money Converter</title>
</head>
<body>
    <form method="POST" action="convert" name="currency_convert_form">
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
        <label>
            <input type="submit" value="Submit" />
        </label>
    </form>

</body>
</html>