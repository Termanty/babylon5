<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RefEngine</title>
    </head>
    <body>
        
        <a href="/references">home</a>
        <h1>References in BibTex Format</h1>

        <c:forEach var="reference" items="${references}">
            <pre>${reference}</pre>
        </c:forEach>

    </body>
</html>
