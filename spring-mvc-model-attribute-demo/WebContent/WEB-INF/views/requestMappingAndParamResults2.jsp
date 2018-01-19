<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@RequestMapping and @RequestParam Test Results 2</title>
</head>
<body>
	<div align="center">
		<h1>${testSerial}: @RequestMapping and @RequestParam Test Results</h1>
		<c:forEach var="parameter" items="${param}">
			<h3 style="color:#DF0101"><c:out value="${parameter.key}"/> = <c:out value="${parameter.value}"/></h3>
		</c:forEach>
	</div>

</body>
</html>