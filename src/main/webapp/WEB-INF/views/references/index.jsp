<%@include file="header.jsp" %>
        
        
<h2 class="page-title">List of references</h2>

<p id="numOfReferences">Number of references: ${amount}</p>

<div>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Link</th>
            <th>Delete</th>
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
                <td>
                    <a href="/references/${reference.id}/delete">delete</a>
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

<%@include file="footer.jsp"%>