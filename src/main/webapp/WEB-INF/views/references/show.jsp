<%-- 
    this page will show information of reference
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RefEngine</title>
    </head>
    <body>
        
        <h1>Reference information page</h1>
        
        <div>
            Name: ${reference.name} <br/>
            Author: ${reference.author} <br/>
        </div>
        
        <div>
            <a href="/references">home</a>
        </div>
        
    </body>
</html>
