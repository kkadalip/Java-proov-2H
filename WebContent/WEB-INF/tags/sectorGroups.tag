<%@ attribute name="list" required="true" 
type="org.hibernate.collection.internal.PersistentSortedSet" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty list}">
    <c:forEach var="item" items="${list}">
        <option value="${item.id}">&nbsp;&nbsp;${item.name}</option>
        <myTags:sectorGroups list="${item.child_sectors}"/>
    </c:forEach>
</c:if>