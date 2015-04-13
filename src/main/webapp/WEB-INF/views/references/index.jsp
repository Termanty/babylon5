
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RefEngine</title>
    </head>
    <body>
        <h1>List of references</h1>
        
        number of references: ${amount} <br/>
        
        <div>
            <ol>
                <c:forEach var="reference" items="${references}">
                    <li>${reference.name} ${reference.author}</li>
                </c:forEach>
            </ol>
        </div>
                
        <div>
            <a href="/references/new">new</a>
        </div>
    </body>
                  
</html>
