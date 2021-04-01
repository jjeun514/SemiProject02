<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%  response.setStatus(HttpServletResponse.SC_OK); %>
<html>
<head>
<title>405에러 페이지</title>
<style type="text/css">
	img{
		display: block;
		margin: auto;
		width:80%;
		height: 100%
		
		}
</style>
</head>
<body>
  <img alt="" src="${pageContext.request.contextPath }/imgs/405img.png">
</body>
</html>