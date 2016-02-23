<%@ attribute name="list" required="true"
	type="org.hibernate.collection.internal.PersistentSortedSet"%>

<%@ attribute name="outerIndex" required="true" type="java.lang.Integer"%>

<%@ attribute name="level" required="true" type="java.lang.Integer"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="lvl" value="${level}" scope="page" />

<c:if test="${!empty list}">
	<c:forEach var="item" items="${list}" varStatus="innerLoop">
		<!-- varStatus="innerLoop"> -->
		<option value="${item.id}">
			<c:forEach begin="0" end="${lvl}" varStatus="loop">
			x
			</c:forEach> ${innerLoop.index}-${item.name}
		</option>
		<myTags:sectorGroups level="${lvl + 1}" outerIndex="${outerIndex}"
			list="${item.child_sectors}" />
	</c:forEach>
</c:if>