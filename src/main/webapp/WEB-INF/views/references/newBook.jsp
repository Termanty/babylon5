<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RefEnginen</title>
    </head>
    <body>
        
        <h1>Create a New Book Reference</h1>
        
        <div class="add-form">
            Enter name and author of the reference:<br/>

            <form action="/references" method="POST">
                <table>
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
                            Author / Editor: 
                        </td>
                        <td>
                            <input type="text" name="author" id="author"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Publisher:
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
                            <input type="text" name="pubYear" id="number" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Volume/Number (optional):
                        </td>
                        <td>
                            <input type="text" name="volume" id="volume" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Series (optional):
                        </td>
                        <td>
                            <input type="text" name="series" id="number" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Address (optional):
                        </td>
                        <td>
                            <input type="text" name="address" id="pages" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Edition (optional):
                        </td>
                        <td>
                            <input type="text" name="edition" id="pages" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Month (optional):
                        </td>
                        <td>
                            <input type="text" name="pubMonth" id="month" />
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
                            <input type="text" name="pubKey" id="key" />
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
