<%@include file="header.jsp" %>

<h2 class="page-title">Create a New Book Reference</h2>

<div class="add-form">
    Enter name and author of the reference:<br/>

    <form action="/references/newBook" method="POST">
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
                    Author / Editor: 
                </td>
                <td>
                    <input type="text" name="author" id="author" required/>
                </td>
            </tr>
            <tr>
                <td>
                    Publisher:
                </td>
                <td>
                    <input type="text" name="publisher" id="publisher" required/>
                </td>
            </tr>
            <tr>
                <td>
                    Year:
                </td>
                <td>
                    <input type="text" name="pubYear" id="pubYear" required/>
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
                    Address (optional):
                </td>
                <td>
                    <input type="text" name="address" id="address" />
                </td>
            </tr>
            <tr>
                <td>
                    Edition (optional):
                </td>
                <td>
                    <input type="text" name="edition" id="edition" />
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

<%@include file="footer.jsp"%>