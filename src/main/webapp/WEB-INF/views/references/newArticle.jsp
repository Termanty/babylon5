<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RefEnginen</title>
    </head>
    <body>
        
        <h1>Create a New Article Reference</h1>
        
        <div class="add-form">
            Enter name and author of the reference:<br/>

            <form action="/references/newArticle" method="POST">
                <table>
                    <!--<input type="hidden" name="refType" id="refType" value="article" />-->
                    <tr>
                        <td>
                            Title: 
                        </td>
                        <td>
                            <input type="text" name="title" id="title"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Author: 
                        </td>
                        <td>
                            <input type="text" name="author" id="author"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Journal:
                        </td>
                        <td>
                            <input type="text" name="journal" id="journal" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Year:
                        </td>
                        <td>
                            <input type="text" name="pubYear" id="pubYear" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Volume:
                        </td>
                        <td>
                            <input type="text" name="volume" id="volume" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Number (optional):
                        </td>
                        <td>
                            <input type="text" name="number" id="number" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Pages (optional):
                        </td>
                        <td>
                            <input type="text" name="pages" id="pages" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Month (optional):
                        </td>
                        <td>
                            <input type="text" name="pubMonth" id="pubMonth" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Note (optional):
                        </td>
                        <td>
                            <input type="text" name="note" id="note" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Key (optional): 
                        </td>
                        <td>
                            <input type="text" name="key" id="key" />
                        </td>
                    </tr>
                </table>
                <input type="submit"/>           
            </form>
        </div>
        
        <div>
            <a href="/references">home</a>
        </div>
        
    </body>
</html>
