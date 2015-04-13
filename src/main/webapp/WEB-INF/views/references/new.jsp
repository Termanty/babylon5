<%-- 
    In this page user can create new reference
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RefEnginen</title>
    </head>
    <body>
        
        <h1>Create a New Reference</h1>
        
        <div>
            Enter name and author of the reference:<br/>

            <form action="/references" method="POST">
                Name: <input type="text" name="name" id="name"/><br/>
                Author: <input type="text" name="author" id="author"/><br/>
                <input type="submit"/>           
            </form>
        </div>
        
        <div>
            <a href="/references">home</a>
        </div>
        
    </body>
</html>
