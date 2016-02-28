<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url value="/" var="base" />
<!-- 
<c:url value="Part" var="homeLink" />
<c:url value="Search" var="searchLink" />
<c:url value="Add" var="addLink" />
<c:url value="Admin" var="adminLink" />
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">

<title>Helmes proov</title>

<meta http-equiv="Content-Security-Policy" content="
    default-src 'self';
    script-src 'self' 'unsafe-inline' https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js;
    connect-src 'self';
    font-src 'self';
    img-src 'self';
    style-src 'self' 'unsafe-inline';
    media-src 'self';">
    
<style type="text/css">
	@import url("${base}/static/style.css");
</style>
<!-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
 -->
<script src="static/default.js"></script>
<!-- 
<script>
var selectedSectors = "${requestScope['SESSIONselectedSectors']}";
//jQuery(document).ready(function () {

//jQuery(window).load(function (){
//	selectOptions(selectedSectors);
//});
console.log("selectedSectors size: " + selectedSectors.length);
window.onload = selectOptions(selectedSectors);
console.log("wtf");
</script>
 -->
</head>
<body>
	<!-- < %@ include file="menu.jsp"%> -->
	<form method="post" action="Default">
	 	Please enter your name and pick the Sectors you are currently involved in.
		<br>
		<br>
		<!-- <c:out value="SESSION NAME: ${requestScope['SESSIONuserName']}"/> -->
		Name: <input required type="text" name="userNameDefault" value="<c:out value="${sessionScope['SESSIONuserName']}"/>">
	<!-- <input type="submit" value="Save">  -->
		<!--  
		<input name="searchString" id="searchStringBox" value="" /> <input
			type="submit" id="filterButton" value="Filtreeri" /> <br /> <br />
	-->
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">[User ID]</th>
					<th scope="col">[User name]</th>
					<th scope="col">[Agreed to terms]</th>
					<th scope="col">[Date added]</th>
					<th scope="col">[User sectors]</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope['displayedUsers']}" var="item">
					<tr>
						<td>
							<div id="row_"<c:out value="${item.id}"/>>ID: <c:out value="${item.id}"/></div>
						</td>
						<td>
							<div>Name: <c:out value="${item.name}"/></div>
						</td>
						<td>
							<div>Agreed: <c:out value="${item.agreedToTerms}"/></div>
						</td>
						<td>
							<div>Date: <c:out value="${item.dateAdded}"/></div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<!-- 
		<table class="listTable2" id="listTable2">
			<thead>
				<tr>
					<th scope="col">Sector</th>
					<th scope="col">Sector name</th>
					<th scope="col">Whatever...</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope['displayedSectors']}" var="item">
					<tr>
						<td>
							<div id="row_${item.id}">ID: ${item.id}</div>
						</td>
						<td>Sector name: ${item.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
 -->

		<br /> Sectors: <select required name="selectSectors" multiple="multiple" size="15">
			<c:forEach items="${sessionScope['displayedSectors']}" var="item" varStatus="outerLoop">
				<option id="option_${item.id}" value="${item.id}"><!-- [${outerLoop.index}]] --><c:out value="${item.name}"/></option>
				
				<myTags:sectorGroups level="0" outerIndex="${outerLoop.index}" list="${item.child_sectors}"/> <!--  pass outerLoop.index !!! -->


			</c:forEach>
		</select>
		
		<br />
		${fn:length(sessionScope['SESSIONselectedSectors'])} length
		
		<c:forEach items="${sessionScope['SESSIONselectedSectors']}" var="item">
			<c:out value="${item}" />
			<script>
				selectOption('${item}');
			</script>
		</c:forEach>

		<!-- <c:out value="${requestScope['SESSIONselectedSectors']}" /> -->

		
	<br />
	<br />
	<input required id="id_accept_terms" type="checkbox" name="accept_terms" <c:if test="${sessionScope['SESSIONcheckbox_checked'] eq true}">checked</c:if> > Agree to terms
	<br />
	<br />
	<input type="submit" value="Save">
	</form>

</body>
</html>