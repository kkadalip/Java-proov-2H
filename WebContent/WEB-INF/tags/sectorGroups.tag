<%@ attribute name="list" required="true" 
type="org.hibernate.collection.internal.PersistentSortedSet" %>

<%@ attribute name="outerIndex" required="true" 
type="java.lang.Integer" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty list}">
    <c:forEach var="item" items="${list}" varStatus="innerLoop"> <!-- varStatus="innerLoop"> -->
        <!-- 
        <option value="${item.id}">&nbsp;&nbsp;${innerLoop.index}-${item.name}</option> 
        -->
        <option value="${item.id}">
        <!-- 
        <c:forEach begin="0" end="${innerLoop.index}" varStatus="loop">
        	&nbsp;&nbsp;
        </c:forEach>
         -->
        <c:forEach begin="0" end="${outerIndex}" varStatus="loop">
        	&nbsp;&nbsp;
        </c:forEach>
        ${innerLoop.index}-${item.name}</option>
        <myTags:sectorGroups outerIndex="${outerIndex}" list="${item.child_sectors}"/>
    </c:forEach>
</c:if>