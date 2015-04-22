<%@include file="header.jsp" %>
        
<a href="/references">home</a>
<h2 class="page-title">References in BibTex Format</h2>

<c:forEach var="reference" items="${references}">
    <pre>${reference}</pre>
</c:forEach>

<%@include file="footer.jsp"%>