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

		<option id="option_${item.id}" value="${item.id}">
			<!--[${innerLoop.index}]${item.name}-->
			<c:forEach begin="0" end="${lvl}" varStatus="loop">&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>${item.name}
		</option>
		
		<c:if test="${not empty item.child_sectors}">
			<!-- BREAKS HERE: -->
			<myTags:sectorGroups level="${lvl + 1}" outerIndex="${outerIndex}" list="${item.child_sectors}" />			
		</c:if>
		
	</c:forEach>
</c:if>