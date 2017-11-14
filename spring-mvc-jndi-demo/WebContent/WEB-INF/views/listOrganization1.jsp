<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listing organizations using the JSTL Sql tag</title>
</head>
<body>
	<h1>Listing organizations using the JSTL sql tag</h1>
	<sql:query var="rs" dataSource="jdbc/spring_db">
		SELECT * FROM organization
	</sql:query>
	
	<c:forEach var="row" items="${rs.rows}">
		Name: ${row.company_name} <br/>
		Year: ${row.year_of_incorporation} <br/>
		Zip: ${row.postal_code} <br/>
		Emp count: ${row.employee_count} <br/>
		Slogan: ${row.slogan} <br/><br/>
	</c:forEach>

</body>
</html>