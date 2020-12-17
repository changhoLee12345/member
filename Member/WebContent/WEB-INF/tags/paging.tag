<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>${params }</div>
<script>
	function goPage(page) {
		console.log(page);
	}
</script>
<div class="paginate">
    <a href="javascript:goPage(${params.firstPageNo})" class="first">first page</a>
    <a href="javascript:goPage(${params.prevPageNo})" class="prev">prev page</a>
    <span>
        <c:forEach var="i" begin="${params.startPageNo}" end="${params.endPageNo}" step="1">
            <c:choose>
                <c:when test="${i eq params.pageNo}"><a href="javascript:goPage(${i})" class="choice">${i}</a></c:when>
                <c:otherwise><a href="javascript:goPage(${i})">${i}</a></c:otherwise>
            </c:choose>
        </c:forEach>
    </span>
    <a href="javascript:goPage(${params.nextPageNo})" class="next">next page</a>
    <a href="javascript:goPage(${params.finalPageNo})" class="last">last page</a>
</div>
