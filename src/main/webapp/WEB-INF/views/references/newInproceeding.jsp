<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RefEnginen</title>
    </head>
    <body>
        
        <h1>Create a New Inproceeding Reference</h1>
        
        <div class="add-form">
            Enter name and author of the reference:<br/>

            <form action="/references/newInproceeding" method="POST">
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
                            Author: 
                        </td>
                        <td>
                            <input type="text" name="author" id="author"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Booktitle: 
                        </td>
                        <td>
                            <input type="text" name="bookTitle" id="bookTitle"/>
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
                            Editor (optional):
                        </td>
                        <td>
                            <input type="text" name="editor" id="editor" />
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
                            <input type="text" name="series" id="series" />
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
                            Address (optional):
                        </td>
                        <td>
                            <input type="text" name="address" id="address" />
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
                            Organization (optional):
                        </td>
                        <td>
                            <input type="text" name="organization" id="organisation" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Publisher (optional):
                        </td>
                        <td>
                            <input type="text" name="publisher" id="publisher" />
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
                            <input type="text" name="pubKey" id="pubKey" />
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
