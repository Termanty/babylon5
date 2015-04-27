<%@include file="header.jsp" %>
        
        <h2 class="page-title">Create a New Article Reference</h2>

<div class="add-form">
    Enter name and author of the reference:<br/>

    <form action="/references/newArticle" method="POST">
        
        <table>
            <tr>
                <td>
                    Title: 
                </td>
                <td>
                    <input type="text" name="title" id="title" required/>
                </td>
            </tr>
            <tr>
                <td>
                    Author: 
                </td>
                <td>
                    <input type="text" name="author" id="author" required/>
                </td>
            </tr>
            <tr>
                <td>
                    Journal:
                </td>
                <td>
                    <input type="text" name="journal" id="journal" required/>
                </td>
            </tr>
            <tr>
                <td>
                    Year:
                </td>
                <td>
                    <input type="text" name="pubYear" id="pubYear" pattern=".{4,}"   required title="4 characters minimum"/>
                </td>
            </tr>
            <tr>
                <td>
                    Volume:
                </td>
                <td>
                    <input type="text" name="volume" id="volume" required/>
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
            <tr class="show-next-hidden">
                <td>
                </td>
                <td>
                    <a href="#" >Specify key</a>
                </td>
            </tr>
            <tr class="hidden">
                <td>
                    Key (optional): 
                </td>
                <td>
                    <input type="text" name="pubKey" id="pubKey" /><br />
                </td>
            </tr>
        </table>
        <input type="submit"/>           
    </form>
</div>
        
<%@include file="footer.jsp"%>