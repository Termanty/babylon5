
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
        
        number of references: ${amount} <br/></br>
        
        <div>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Link</th>
                </tr>
                <c:forEach var="reference" items="${references}">
                    <tr>
                        <td>
                            ${reference.title} 
                        </td>
                        <td>
                            ${reference.author}
                        </td>
                        <td>
                            <a href="/references/${reference.id}">link</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        </br>        
        <div>
            <a href="/references/newReference">newReference</a> |
            <a href="/references/bibtex">bibtex</a>   
        </div>
        
    </body>             
</html>
