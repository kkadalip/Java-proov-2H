<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="base" />
<!-- 
<c:url value="Part" var="homeLink" />
<c:url value="Search" var="searchLink" />
<c:url value="Add" var="addLink" />
<c:url value="Admin" var="adminLink" />
 -->
 
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<!-- <html xmlns="http://www.w3.org/1999/xhtml"> -->
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">
<title>Helmes proov</title>

<style type="text/css">
<!--
@import url("${base}/static/style.css");
-->
</style>
</head>
<body>
	<h2>Well hello There!</h2>
	<br>
		<h3>
			Date=<%=new Date()%>
		</h3> 
		
		<%="Hello World!"%>

		<form action="query" method="post">
			<input type="submit" name="jdbc_query" value="Query DB" />
		</form>
		Please enter your name and pick the Sectors you are currently involved in. <br> <br>
		Name: <input type="text"> <br />
			<br /> Sectors: <select multiple size="5">
				<option value="1">Manufacturing</option>
				<option value="19">&nbsp;&nbsp;&nbsp;&nbsp;Construction
					materials</option>
				<option value="18">&nbsp;&nbsp;&nbsp;&nbsp;Electronics and
					Optics</option>
				<option value="6">&nbsp;&nbsp;&nbsp;&nbsp;Food and Beverage</option>
				<option value="342">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bakery
					&amp; confectionery products</option>
				<option value="43">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Beverages</option>
				<option value="42">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fish
					&amp; fish products</option>
				<option value="40">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Meat
					&amp; meat products</option>
				<option value="39">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Milk
					&amp; dairy products</option>
				<option value="437">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Other</option>
				<option value="378">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sweets
					&amp; snack food</option>
				<option value="13">&nbsp;&nbsp;&nbsp;&nbsp;Furniture</option>
				<option value="389">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bathroom/sauna
				</option>
				<option value="385">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bedroom</option>
				<option value="390">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Childrenâs
					room</option>
				<option value="98">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kitchen
				</option>
				<option value="101">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Living
					room</option>
				<option value="392">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Office</option>
				<option value="394">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Other
					(Furniture)</option>
				<option value="341">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Outdoor
				</option>
				<option value="99">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Project
					furniture</option>
				<option value="12">&nbsp;&nbsp;&nbsp;&nbsp;Machinery</option>
				<option value="94">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Machinery
					components</option>
				<option value="91">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Machinery
					equipment/tools</option>
				<option value="224">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Manufacture
					of machinery</option>
				<option value="97">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Maritime</option>
				<option value="271">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Aluminium
					and steel workboats</option>
				<option value="269">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Boat/Yacht
					building</option>
				<option value="230">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ship
					repair and conversion</option>
				<option value="93">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Metal
					structures</option>
				<option value="508">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Other</option>
				<option value="227">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Repair
					and maintenance service</option>
				<option value="11">&nbsp;&nbsp;&nbsp;&nbsp;Metalworking</option>
				<option value="67">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Construction
					of metal structures</option>
				<option value="263">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Houses
					and buildings</option>
				<option value="267">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Metal
					products</option>
				<option value="542">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Metal
					works</option>
				<option value="75">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CNC-machining</option>
				<option value="62">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Forgings,
					Fasteners</option>
				<option value="69">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gas,
					Plasma, Laser cutting</option>
				<option value="66">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MIG,
					TIG, Aluminum welding</option>
				<option value="9">&nbsp;&nbsp;&nbsp;&nbsp;Plastic and
					Rubber</option>
				<option value="54">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Packaging</option>
				<option value="556">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plastic
					goods</option>
				<option value="559">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plastic
					processing technology</option>
				<option value="55">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Blowing</option>
				<option value="57">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Moulding</option>
				<option value="53">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plastics
					welding and processing</option>
				<option value="560">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plastic
					profiles</option>
				<option value="5">&nbsp;&nbsp;&nbsp;&nbsp;Printing</option>
				<option value="148">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Advertising</option>
				<option value="150">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Book/Periodicals
					printing</option>
				<option value="145">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Labelling
					and packaging printing</option>
				<option value="7">&nbsp;&nbsp;&nbsp;&nbsp;Textile and
					Clothing</option>
				<option value="44">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Clothing</option>
				<option value="45">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Textile</option>
				<option value="8">&nbsp;&nbsp;&nbsp;&nbsp;Wood</option>
				<option value="337">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Other
					(Wood)</option>
				<option value="51">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wooden
					building materials</option>
				<option value="47">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wooden
					houses</option>
				<option value="3">Other</option>
				<option value="37">&nbsp;&nbsp;&nbsp;&nbsp;Creative
					industries</option>
				<option value="29">&nbsp;&nbsp;&nbsp;&nbsp;Energy
					technology</option>
				<option value="33">&nbsp;&nbsp;&nbsp;&nbsp;Environment</option>
				<option value="2">Service</option>
				<option value="25">&nbsp;&nbsp;&nbsp;&nbsp;Business
					services</option>
				<option value="35">&nbsp;&nbsp;&nbsp;&nbsp;Engineering</option>
				<option value="28">&nbsp;&nbsp;&nbsp;&nbsp;Information
					Technology and Telecommunications</option>
				<option value="581">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Data
					processing, Web portals, E-marketing</option>
				<option value="576">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Programming,
					Consultancy</option>
				<option value="121">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Software,
					Hardware</option>
				<option value="122">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Telecommunications</option>
				<option value="22">&nbsp;&nbsp;&nbsp;&nbsp;Tourism</option>
				<option value="141">&nbsp;&nbsp;&nbsp;&nbsp;Translation
					services</option>
				<option value="21">&nbsp;&nbsp;&nbsp;&nbsp;Transport and
					Logistics</option>
				<option value="111">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Air</option>
				<option value="114">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rail</option>
				<option value="112">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Road</option>
				<option value="113">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Water</option>
		</select> <br /> <br /> <input type="checkbox"> Agree to terms <br />
				<br /> <input type="submit" value="Save">

					<h1>User name saving form</h1>
					<form action="save" method="post">
						<!-- action here is what matters -->
						<table cellpadding="3pt">
							<tr>
								<td>User Name:</td>
								<td><input type="text" name="userName" size="30" /></td>
							</tr>
						</table>
						<p />
						<input type="submit" value="Save" />
						<!-- Register -->
					</form>



	<!-- < %@ include file="menu.jsp"%> -->
	<form method="get" action="Default">
	<!--  
		<input name="searchString" id="searchStringBox" value="" /> <input
			type="submit" id="filterButton" value="Filtreeri" /> <br /> <br />
	-->
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Whatever1</th>
					<th scope="col">Whatever2</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope['displayedUsers']}" var="item">
					<tr>
						<td>
						<div id="row_">ID: ${item.id}</div>
							<!-- <div id="row_${item.code}">${item.name}</div> -->
						</td>
						<!-- <td>${item.code}</td> -->
						<td>Name: ${item.name}</td>
						<!-- <td><a href="Search?do=delete&id=${item.id}"
							id="delete_${item.code}">Kustuta</a></td> -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>