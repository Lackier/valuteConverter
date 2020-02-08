<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="sumObtained" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="sum" scope="request" type="java.lang.Integer"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Money Converter</title>
</head>
<body>
    <form method="POST">
        <label>
            <input name="sum" type="number" min="0" ${sum}/>
        </label>
        <label>
            <input name="sumObtained" type="number" min="0" ${sumObtained}/>
        </label>
        <label>
            <input type="submit" value="Submit" />
        </label>
    </form>

</body>
</html>